package me.GFelberg.InventoryView.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import me.GFelberg.InventoryView.Main;
import me.GFelberg.InventoryView.data.InventorySystem;

public class InventoryEvents implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {

		if (event.getClickedInventory() == null) {
			return;
		}
		Player p = (Player) event.getWhoClicked();
		String title = event.getView().getTitle();
		String player_inv = "%player_inv_title%";
		String player_echest = "%player_echest_title%";
		FileConfiguration config = Main.getInstance().getConfig();

		if (title.equalsIgnoreCase(
				player_inv.replace("%player_inv_title%", InventorySystem.player_inv_name) + " - Inventory")) {
			if (!(config.getBoolean("InventoryProtection.Interact"))) {
				return;
			} else {
				if (config.getBoolean("InventoryProtection.BlockAdmin")) {
					event.setCancelled(true);
				} else {
					if (p.hasPermission("inventoryview.bypass")) {
						return;
					} else {
						event.setCancelled(true);
					}
				}
			}
		}

		else if (title.equalsIgnoreCase(
				player_echest.replace("%player_echest_title%", InventorySystem.player_echest_name) + " - Enderchest")) {
			if (!(config.getBoolean("InventoryProtection.Interact"))) {
				return;
			} else {
				if (config.getBoolean("InventoryProtection.BlockAdmin")) {
					event.setCancelled(true);
				} else {
					if (p.hasPermission("inventoryview.bypass")) {
						return;
					} else {
						event.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent event) {
		Player p = (Player) event.getWhoClicked();
		String player_inv = "%player_inv_title%";
		String player_echest = "%player_echest_title%";
		FileConfiguration config = Main.getInstance().getConfig();
		String title = event.getView().getTitle();

		if (title.equalsIgnoreCase(
				player_inv.replace("%player_inv_title%", InventorySystem.player_inv_name) + " - Inventory")) {
			if (!(config.getBoolean("InventoryProtection.Interact"))) {
				return;
			} else {
				if (config.getBoolean("InventoryProtection.BlockAdmin")) {
					event.setCancelled(true);
				} else {
					if (p.hasPermission("inventoryview.bypass")) {
						return;
					} else {
						event.setCancelled(true);
					}
				}
			}
		}

		else if (title.equalsIgnoreCase(
				player_echest.replace("%player_echest_title%", InventorySystem.player_echest_name) + " - Enderchest")) {
			if (!(config.getBoolean("InventoryProtection.Interact"))) {
				return;
			} else {
				if (config.getBoolean("InventoryProtection.BlockAdmin")) {
					event.setCancelled(true);
				} else {
					if (p.hasPermission("inventoryview.bypass")) {
						return;
					} else {
						event.setCancelled(true);
					}
				}
			}
		}
	}
}
