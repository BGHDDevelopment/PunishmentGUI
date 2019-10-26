package me.noodles.gui.updatechecker;

import me.noodles.gui.util.Settings;
import org.bukkit.event.player.*;

import me.noodles.gui.PunishmentGUI;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinEvents implements Listener {

    public UpdateChecker checker;

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (PunishmentGUI.plugin.getConfig().getBoolean("Update.Enabled") == true) {
        if (p.hasPermission("punishmentgui.update")) {
                this.checker = new UpdateChecker(PunishmentGUI.plugin);
                if (this.checker.isConnected()) {
                    if (this.checker.hasUpdate()) {
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                        p.sendMessage(ChatColor.RED + "PunishmentGUI is outdated!");
                        p.sendMessage(ChatColor.RED + "Newest version: " + ChatColor.GREEN + ChatColor.BOLD + this.checker.getLatestVersion());
                        p.sendMessage(ChatColor.RED + "Your version: " + ChatColor.BOLD + Settings.VERSION);
                        p.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                    }
                }
            }
        }
    }


    @EventHandler
    public void onDevJoin(PlayerJoinEvent e) { //THIS EVENT IS USED FOR DEBUG REASONS ONLY!
        Player p = e.getPlayer();
        this.checker = new UpdateChecker(PunishmentGUI.plugin);
        if (p.getName().equals("Noodles_YT")) {
            p.sendMessage(ChatColor.RED + "BGHDDevelopment Debug Message");
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GREEN + "This server is using " + Settings.NAME + " version " + Settings.VERSION);
            p.sendMessage(ChatColor.GREEN + "The newest version is " + this.checker.getLatestVersion());
            p.sendMessage(" ");

     } else {
            return;
        }
    }

}
    