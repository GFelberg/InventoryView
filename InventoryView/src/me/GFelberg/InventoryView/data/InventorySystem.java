package me.GFelberg.InventoryView.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.GFelberg.InventoryView.Main;

public class InventorySystem {

	public static String player_inv, player_inv_self, player_notfound;
	public static String player_echest, player_echest_self;
	public static volatile String player_inv_name, player_echest_name;

	public static void loadVariables() {
		player_inv = Main.getInstance().getConfig().getString("PlayerInventory.Message").replace("&", "§");
		player_inv_self = Main.getInstance().getConfig().getString("PlayerInventory.Yourself").replace("&", "§");

		player_echest = Main.getInstance().getConfig().getString("PlayerEnderchest.Message").replace("&", "§");
		player_echest_self = Main.getInstance().getConfig().getString("PlayerEnderchest.Yourself").replace("&", "§");

		player_notfound = Main.getInstance().getConfig().getString("InventoryView.PlayerNotFound").replace("&", "§");
	}

	public void openPlayerInventory(Player p, Player selected) {

		if (selected == null) {
			p.sendMessage(player_notfound);
			return;
			// } else if (selected == p) {
			// p.sendMessage(player_inv_self);
			// return;
		} else {
			Inventory inv = selected.getInventory();
			String player_inv_title = "%player_inv_title%";
			Inventory updatedInventory = Bukkit.createInventory(null, inv.getType(),
					player_inv_title.replace("%player_inv_title%", selected.getName() + " - Inventory"));
			updatedInventory.setContents(inv.getContents());
			selected.openInventory(updatedInventory);
			player_inv_name = selected.getName();
		}
		p.sendMessage(player_inv.replace("%player_inv%", selected.getName()));
	}

	public void openPlayerEnderchest(Player p, Player selected) {

		if (selected == null) {
			p.sendMessage(player_notfound);
			return;
			// } else if (selected == p) {
			// p.sendMessage(player_echest_self);
			// return;
		} else {
			Inventory inv = selected.getEnderChest();
			String player_echest_title = "%player_echest_title%";
			Inventory updatedInventory = Bukkit.createInventory(null, inv.getType(),
					player_echest_title.replace("%player_echest_title%", selected.getName()) + " - Enderchest");
			updatedInventory.setContents(inv.getContents());
			selected.openInventory(updatedInventory);
			player_echest_name = selected.getName();
		}
		p.sendMessage(player_echest.replace("%player_echest%", selected.getName()));
	}
}