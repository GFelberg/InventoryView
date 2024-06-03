package me.GFelberg.InventoryView.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.GFelberg.InventoryView.utils.InventoryViewUtils;

public class InventoryView implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("inventoryview")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "This command can be only made by players!");
				return true;
			}

			if (!(sender.hasPermission("inventoryview.admin"))) {
				sender.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Usage: /iv help");
				return true;
			}

			if (args.length == 1) {
				Player p = (Player) sender;
				InventoryViewUtils utils = new InventoryViewUtils();

				if (args[0].equalsIgnoreCase("help")) {
					utils.helpPage(p);
				} else if (args[0].equalsIgnoreCase("reload")) {
					utils.reloadConfig(p);
				}
				return true;
			}
		}
		return true;
	}
}