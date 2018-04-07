package me.noodles.gui.inv;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InvCreator {

	    public static Inventory Main;
	    String DownloaderType;
	    String GsonEntry;
	    String SpigotHost;
	    
	    static {
	        InvCreator.Main = Bukkit.createInventory((InventoryHolder)null, 54, InvNames.Main);
	    }
	    
}
