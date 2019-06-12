package me.noodles.gui.main.updatechecker;

import me.noodles.gui.Settings;
import org.bukkit.event.player.*;

import me.noodles.gui.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinEvents implements Listener {

    public UpdateChecker checker;

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("litebansgui.update")) {
            if (Main.plugin.getConfig().getBoolean("Update.Enabled") == true) {
                this.checker = new UpdateChecker(Main.plugin);
                if (this.checker.isConnected()) {
                    if (this.checker.hasUpdate()) {
                        p.sendMessage(ChatColor.GRAY + "=========================");
                        p.sendMessage(ChatColor.RED + "LiteBansGUI is outdated!");
                        p.sendMessage(ChatColor.GREEN + "Newest version: " + this.checker.getLatestVersion());
                        p.sendMessage(ChatColor.RED + "Your version: " + Main.plugin.getDescription().getVersion());
                        p.sendMessage(ChatColor.GRAY + "=========================");
                    }
                }
            }
        }
    }


    @EventHandler
    public void onDevJoin(PlayerJoinEvent e) { //THIS EVENT IS USED FOR DEBUG REASONS ONLY!
        Player p = e.getPlayer();
        this.checker = new UpdateChecker(Main.plugin);
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
    