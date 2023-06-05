package me.GFelberg.InventoryView;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.GFelberg.InventoryView.commands.Invechest;
import me.GFelberg.InventoryView.commands.InventoryView;
import me.GFelberg.InventoryView.commands.Invsee;
import me.GFelberg.InventoryView.data.InventorySystem;
import me.GFelberg.InventoryView.events.InventoryEvents;
import me.GFelberg.InventoryView.utils.InventoryViewUtils;

public class Main extends JavaPlugin {

	private static Main instance;

	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		loadCommands();
		loadVariables();
		Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
		Bukkit.getConsoleSender().sendMessage("InventoryView Plugin Enabled!");
		Bukkit.getConsoleSender().sendMessage("Plugin developed by GFelberg");
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
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
}