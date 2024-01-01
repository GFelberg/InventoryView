package me.GFelberg.InventoryView;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.GFelberg.InventoryView.commands.Invechest;
import me.GFelberg.InventoryView.commands.InventoryView;
import me.GFelberg.InventoryView.commands.Invsee;
import me.GFelberg.InventoryView.data.InventorySystem;
import me.GFelberg.InventoryView.events.InventoryEvents;
import me.GFelberg.InventoryView.utils.InventoryViewUtils;
import me.GFelberg.InventoryView.utils.UpdateChecker;

public class Main extends JavaPlugin implements Listener {

	private static Main instance;

	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		loadCommands();
		loadVariables();
		loadEvents();
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
		Bukkit.getConsoleSender().sendMessage("InventoryView Plugin Enabled!");
		Bukkit.getConsoleSender().sendMessage("Plugin developed by GFelberg");
		Bukkit.getConsoleSender().sendMessage("-----------------------------");

		new UpdateChecker(this, 75100).getVersion(version -> {
			if (this.getDescription().getVersion().equals(version)) {
				getLogger().info("There is not a new update available.");
			} else {
				getLogger().info("There is a new update available.");
			}
		});
	}

	public static Main getInstance() {
		return instance;
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("------------------------------");
		Bukkit.getConsoleSender().sendMessage("InventoryView Plugin Disabled!");
		Bukkit.getConsoleSender().sendMessage("Plugin developed by GFelberg");
		Bukkit.getConsoleSender().sendMessage("------------------------------");
	}

	public void loadCommands() {
		getCommand("inventoryview").setExecutor(new InventoryView());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("invechest").setExecutor(new Invechest());
	}

	public void loadVariables() {
		InventoryViewUtils.loadVariables();
		InventorySystem.loadVariables();
	}

	public void loadEvents() {
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		FileConfiguration config = this.getConfig();

		if (config.getBoolean("update-check") && p.isOp()
				|| config.getBoolean("update-check") && p.hasPermission("inventory.update")) {
			(new UpdateChecker(this, 75100)).getVersion((version) -> {
				if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
					p.sendMessage("There is a new update available of InventoryView.");
				}
			});
		}
	}
}