package me.noodles.gui.inv;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InvCreator {
	public static Inventory Main;

	static {
		InvCreator.Main = Bukkit.createInventory(null, 54, InvNames.Main);
	}
}
