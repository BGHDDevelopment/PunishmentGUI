package me.noodles.gui.inv;

import me.noodles.gui.PunishmentGUI;
import org.bukkit.ChatColor;

public class InvNames {

	public static String Main;

    
    static {
        InvNames.Main = ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("InventoryName"));
    }
}
	
