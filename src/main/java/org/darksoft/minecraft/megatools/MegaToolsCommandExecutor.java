package org.darksoft.minecraft.megatools;

import static org.darksoft.minecraft.megatools.I18n.tl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MegaToolsCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player target = null;

		if (args.length < 1) {
			sender.sendMessage(tl("enoughArguments"));
			return false;
		}

		if (args[0].equalsIgnoreCase("me")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Invalid sender");
				return false;
			}
			target = (Player) sender;
		} else {
			target = (Bukkit.getServer().getPlayer(args[0]));
			if (target == null) {
				sender.sendMessage(tl("playerNoOnline", args[0]));
				return false;
			}
		}

		if (cmd.getName().equalsIgnoreCase("megasword"))
			return commandMegaSword(target, sender, cmd, label, args);

		else if (cmd.getName().equalsIgnoreCase("megaaxe"))
			return commandMegaAxe(target, sender, cmd, label, args);

		else if (cmd.getName().equalsIgnoreCase("megapickaxe"))
			return commandMegaPickaxe(target, sender, cmd, label, args);

		else if (cmd.getName().equalsIgnoreCase("megashovel"))
			return commandMegaShovel(target, sender, label, args);

		else if (cmd.getName().equalsIgnoreCase("megabow"))
			return commandMegaBow(target, sender, label, args);

		else if (cmd.getName().equalsIgnoreCase("megafns"))
			return commandMegaFlintAndSteel(target, sender, label, args);

		else if (cmd.getName().equalsIgnoreCase("megashears"))
			return commandMegaShears(target, sender, label, args);

		else if (cmd.getName().equalsIgnoreCase("megaarmor"))
			return commandMegaArmor(target, sender, label, args);

		return false;
	}

	private boolean commandMegaSword(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fire = true;

		if (args.length > 2) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fire"))
				fire = true;
			else if (args[1].equals("nofire"))
				fire = false;
			else {
				sender.sendMessage(tl("badArgumentN"));
				return false;
			}
		}
		PlayerInventory inventory = target.getInventory();
		ItemStack sword = Tools.getMegaSword(fire);
		inventory.addItem(sword);
		target.sendMessage(tl("powerfulSword"));
		return true;
	}

	private boolean commandMegaAxe(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage(tl("badArgumentF"));
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack axe = Tools.getMegaAxe(fortune);
		inventory.addItem(axe);
		target.sendMessage(tl("powerfulAxe"));
		return true;
	}

	private boolean commandMegaPickaxe(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage(tl("badArgumentF"));
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack pickaxe = Tools.getMegaPickaxe(fortune);
		inventory.addItem(pickaxe);
		target.sendMessage(tl("powerfulPickaxe"));
		return true;
	}

	private boolean commandMegaShovel(Player target, CommandSender sender,
			String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}
		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage(tl("badArgumentF"));
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack shovel = Tools.getMegaShovel(fortune);
		inventory.addItem(shovel);
		target.sendMessage(tl("powerfulShovel"));
		return true;
	}

	private boolean commandMegaBow(Player target, CommandSender sender,
			String label, String[] args) {
		boolean fire = true;

		if (args.length > 2) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}
		if (args.length == 2) {
			if (args[1].equals("fire"))
				fire = true;
			else if (args[1].equals("nofire"))
				fire = false;
			else {
				sender.sendMessage(tl("badArgumentN"));
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack bow = Tools.getMegaBow(fire);
		inventory.addItem(bow);
		ItemStack arrow = new ItemStack(Material.ARROW);
		if (!(inventory.contains(arrow)))
			inventory.addItem(arrow);
		target.sendMessage("You get a powerful axe!");
		return true;
	}

	private boolean commandMegaFlintAndSteel(Player target,
			CommandSender sender, String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}
		PlayerInventory inventory = target.getInventory();
		ItemStack fns = Tools.getMegaFlintAndSteel();
		inventory.addItem(fns);
		target.sendMessage(tl("powerfulFnS"));
		return false;
	}

	private boolean commandMegaShears(Player target, CommandSender sender,
			String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage(tl("tooArguments"));
			return false;
		}
		PlayerInventory inventory = target.getInventory();
		ItemStack shears = Tools.getMegaShears();
		inventory.addItem(shears);
		target.sendMessage(tl("powerfulShears"));
		return false;
	}

	private boolean commandMegaArmor(Player target, CommandSender sender,
			String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		PlayerInventory inventory = target.getInventory();
		inventory.setHelmet(Tools.getMegaHelmet());
		inventory.setChestplate(Tools.getMegaChestplate());
		inventory.setLeggings(Tools.getMegaLeggings());
		inventory.setBoots(Tools.getMegaBoots());
		return true;
	}

}