package me.GFelberg.InventoryView.utils;

import me.GFelberg.InventoryView.Main;

public class HelpPageUtils {

	public String getHelp_page() {
		return Main.getInstance().getConfig().getString("Help.Page").replace("&", "§");
	}

	public String getHelp_invsee() {
		return Main.getInstance().getConfig().getString("Help.Invsee").replace("&", "§");
	}

	public String getHelp_invechest() {
		return Main.getInstance().getConfig().getString("Help.Invechest").replace("&", "§");
	}

	public String getHelp_reload() {
		return Main.getInstance().getConfig().getString("Help.Reload").replace("&", "§");
	}
}