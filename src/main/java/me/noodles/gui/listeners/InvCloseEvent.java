package me.noodles.gui.listeners;

import me.noodles.gui.PunishmentGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InvCloseEvent implements Listener {

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();

        if (PunishmentGUI.getPlugin().getBannedManager().contains(player.getUniqueId())) {
            PunishmentGUI.getPlugin().getBannedManager().remove(player.getUniqueId());
        }
    }
}
