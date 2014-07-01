package org.darksoft.minecraft.megatools;

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
			sender.sendMessage("Not enough arguments!");
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
				sender.sendMessage(args[0] + " is not online!");
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

		else if (cmd.getName().equalsIgnoreCase("megaarmor"))
			return commandMegaArmor(target, sender, label, args);

		return false;
	}

	private boolean commandMegaSword(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fire = true;

		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fire"))
				fire = true;
			else if (args[1].equals("nofire"))
				fire = false;
			else {
				sender.sendMessage("Bad argument: Use fire or nofire");
				return false;
			}
		}
		PlayerInventory inventory = target.getInventory();
		ItemStack sword = MegaTools.getMegaSword(fire);
		inventory.addItem(sword);
		target.sendMessage("You get a powerful sword!");
		return true;
	}

	private boolean commandMegaAxe(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage("Bad argument: Use fortune or silk");
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack axe = MegaTools.getMegaAxe(fortune);
		inventory.addItem(axe);
		target.sendMessage("You get a powerful axe!");
		return true;
	}

	private boolean commandMegaPickaxe(Player target, CommandSender sender,
			Command cmd, String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			return false;
		}

		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage("Bad argument: Use fortune or silk");
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack pickaxe = MegaTools.getMegaPickaxe(fortune);
		inventory.addItem(pickaxe);
		target.sendMessage("You get a powerful axe!");
		return true;
	}

	private boolean commandMegaShovel(Player target, CommandSender sender,
			String label, String[] args) {
		boolean fortune = true;

		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		if (args.length == 2) {
			if (args[1].equals("fortune"))
				fortune = true;
			else if (args[1].equals("silk"))
				fortune = false;
			else {
				sender.sendMessage("Bad argument: Use fortune or silk");
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack shovel = MegaTools.getMegaShovel(fortune);
		inventory.addItem(shovel);
		target.sendMessage("You get a powerful axe!");
		return true;
	}

	private boolean commandMegaBow(Player target, CommandSender sender,
			String label, String[] args) {
		boolean fire = true;

		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		if (args.length == 2) {
			if (args[1].equals("fire"))
				fire = true;
			else if (args[1].equals("nofire"))
				fire = false;
			else {
				sender.sendMessage("Bad argument: Use fire or nofire");
				return false;
			}
		}

		PlayerInventory inventory = target.getInventory();
		ItemStack bow = MegaTools.getMegaBow(fire);
		inventory.addItem(bow);
		ItemStack arrow = new ItemStack(Material.ARROW);
		if (!(inventory.contains(arrow)))
			inventory.addItem(arrow);
		target.sendMessage("You get a powerful axe!");
		return true;
	}

	private boolean commandMegaArmor(Player target, CommandSender sender,
			String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		PlayerInventory inventory = target.getInventory();
		inventory.setHelmet(MegaTools.getMegaHelmet());
		inventory.setChestplate(MegaTools.getMegaChestplate());
		inventory.setLeggings(MegaTools.getMegaLeggings());
		inventory.setBoots(MegaTools.getMegaBoots());
		return true;
	}
}