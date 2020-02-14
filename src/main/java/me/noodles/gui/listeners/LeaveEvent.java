package me.noodles.gui.listeners;

import me.noodles.gui.PunishmentGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onPlayerKick(final PlayerKickEvent event) {
        final Player player = event.getPlayer();

        if (PunishmentGUI.getPlugin().getBannedManager().contains(player.getUniqueId())) {
            PunishmentGUI.getPlugin().getBannedManager().remove(player.getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        if (PunishmentGUI.getPlugin().getBannedManager().contains(player.getUniqueId())) {
            PunishmentGUI.getPlugin().getBannedManager().remove(player.getUniqueId());
        }
    }
}
