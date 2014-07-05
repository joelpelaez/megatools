package org.darksoft.minecraft.megatools;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class I18n {
	private static I18n instance;
	private static final String MESSAGES = "messages";
	private final Locale defaultLocale = Locale.getDefault();
	private Locale currentLocale = defaultLocale;
	private ResourceBundle customBundle;
	private ResourceBundle localeBundle;
	private ResourceBundle defaultBundle;
	private transient Map<String, MessageFormat> messageFormatCache = new HashMap<String, MessageFormat>();
	private static final Pattern NODOUBLEMARK = Pattern.compile("''");
	private static final ResourceBundle NULL_BUNDLE = new ResourceBundle() {
		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

		@Override
		protected Object handleGetObject(String key) {
			return null;
		}
	};

	public I18n() {
		defaultBundle = ResourceBundle.getBundle(MESSAGES, Locale.ENGLISH);
		localeBundle = defaultBundle;
		customBundle = NULL_BUNDLE;
	}

	public void onEnable()
	{
		instance = this;
	}

	public void onDisable()
	{
		instance = null;
	}
	
	private String translate(final String string) {
		try {
			try {
				return customBundle.getString(string);
			} catch (MissingResourceException ex) {
				return localeBundle.getString(string);
			}
		} catch (MissingResourceException ex) {
			Logger.getLogger("MegaTools")
					.log(Level.WARNING,
							String.format(
									"Missing translation key \"%s\" in translation file %s",
									ex.getKey(), localeBundle.getLocale()
											.toString()), ex);
			return defaultBundle.getString(string);
		}
	}

	public static String tl(final String string, final Object... objects) {
		if (instance == null) {
			return "";
		}
		if (objects.length == 0) {
			return NODOUBLEMARK.matcher(instance.translate(string)).replaceAll(
					"'");
		} else {
			return instance.format(string, objects);
		}
	}

	public String format(final String string, final Object... objects) {
		String format = translate(string);
		MessageFormat messageFormat = messageFormatCache.get(format);
		if (messageFormat == null) {
			try {
				messageFormat = new MessageFormat(format);
			} catch (IllegalArgumentException e) {
				Logger.getLogger("MegaTools").log(
						Level.SEVERE,
						"Invalid Translation key for '" + string + "': "
								+ e.getMessage());
				format = format.replaceAll("\\{(\\D*?)\\}", "\\[$1\\]");
				messageFormat = new MessageFormat(format);
			}
			messageFormatCache.put(format, messageFormat);
		}
		return messageFormat.format(objects);
	}

	public void updateLocale(final String loc) {
		if (loc != null && !loc.isEmpty()) {
			final String[] parts = loc.split("[_\\.]");
			if (parts.length == 1) {
				currentLocale = new Locale(parts[0]);
			}
			if (parts.length == 2) {
				currentLocale = new Locale(parts[0], parts[1]);
			}
			if (parts.length == 3) {
				currentLocale = new Locale(parts[0], parts[1], parts[2]);
			}
		}
		ResourceBundle.clearCache();
		messageFormatCache = new HashMap<String, MessageFormat>();
		Logger.getLogger("MegaTools").log(Level.INFO,
				String.format("Using locale %s", currentLocale.toString()));

		try {
			localeBundle = ResourceBundle.getBundle(MESSAGES, currentLocale);
		} catch (MissingResourceException ex) {
			localeBundle = NULL_BUNDLE;
		}
	}

	public static String capitalCase(final String input) {
		return input == null || input.length() == 0 ? input : input
				.toUpperCase(Locale.ENGLISH).charAt(0)
				+ input.toLowerCase(Locale.ENGLISH).substring(1);
	}

}
