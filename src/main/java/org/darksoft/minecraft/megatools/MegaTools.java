package org.darksoft.minecraft.megatools;

import java.util.Locale;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Principal class (Plugin Loader)
 * 
 * @author Joel Pelaez Jorge
 * @since 1.0b
 * @version 1.1b
 */
public class MegaTools extends JavaPlugin {

	public static final String VERSION = "1.1b";
	private MegaToolsCommandExecutor mExecutor;
	private I18n mI18n;
	public static Logger LOGGER;

	@Override
	public void onEnable() {

		mI18n = new I18n();
		mI18n.onEnable();
		/* Only support spanish translations. */
		if (Locale.getDefault().getLanguage().equals("es"))
			mI18n.updateLocale(null);

		mExecutor = new MegaToolsCommandExecutor();

		getCommand("megasword").setExecutor(mExecutor);
		getCommand("megaaxe").setExecutor(mExecutor);
		getCommand("megapickaxe").setExecutor(mExecutor);
		getCommand("megashovel").setExecutor(mExecutor);
		getCommand("megabow").setExecutor(mExecutor);
		getCommand("megafns").setExecutor(mExecutor);
		getCommand("megashears").setExecutor(mExecutor);
		getCommand("megaarmor").setExecutor(mExecutor);

		getLogger().info(ChatColor.AQUA + "Enabled MegeTools Beta");
	}

	@Override
	public void onDisable() {
		mI18n.onDisable();
		getLogger().info("Disabled MegaTools Beta");
	}

}
