package me.GFelberg.InventoryView.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.GFelberg.InventoryView.utils.InventoryViewUtils;

public class Invsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("invsee")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "This command can be only made by players!");
				return true;
			}

			if (!(sender.hasPermission("invsee.admin"))) {
				sender.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Usage: /invsee <player>");
				return true;
			}

			if (args.length == 1) {
				Player p = (Player) sender;
				Player selected = Bukkit.getServer().getPlayer(args[0]);
				InventoryViewUtils utils = new InventoryViewUtils();
				utils.openPlayerInventory(p, selected);
				return true;
			}
		}
		return true;
	}
}