package me.GFelberg.InventoryView.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.GFelberg.InventoryView.Main;

public class InventoryViewUtils {

	public static String prefix;

	public static void loadVariables() {
		prefix = Main.getInstance().getConfig().getString("InventoryView.Prefix").replace("&", "§");
	}

	public void reloadConfig(Player p) {

		if (!(p.hasPermission("inventoryview.reload"))) {
			p.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
		} else {
			Main.getInstance().reloadConfig();
			Main.getInstance().loadVariables();
			p.sendMessage(prefix + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			Bukkit.getConsoleSender().sendMessage("===============================================");
			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "InventoryView Plugin reloaded");
			Bukkit.getConsoleSender().sendMessage("===============================================");
		}
	}

	public void helpPage(Player p) {
		HelpPageUtils helpUtils = new HelpPageUtils();
		p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		p.sendMessage(ChatColor.AQUA + "InventoryView - Help Commands");
		p.sendMessage(ChatColor.YELLOW + "/iv help: " + helpUtils.getHelp_page());
		p.sendMessage(ChatColor.YELLOW + "/invsee <player> : " + helpUtils.getHelp_invsee());
		p.sendMessage(ChatColor.YELLOW + "/invechest <player> : " + helpUtils.getHelp_invechest());
		p.sendMessage(ChatColor.YELLOW + "/iv reload : " + helpUtils.getHelp_reload());
		p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
	}
}