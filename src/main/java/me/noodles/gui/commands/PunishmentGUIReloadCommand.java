package me.noodles.gui.commands;

import me.noodles.gui.PunishmentGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishmentGUIReloadCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getServer().getLogger().warning(PunishmentGUI.getPlugin().getConfig().getString("NoPlayer"));
            return true;
        }

        final Player p = (Player) sender;

        if (!cmd.getName().equalsIgnoreCase("punishmentguireload")) {
            return true;
        }

        if (!sender.hasPermission("punish.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.getPlugin().getConfig().getString("NoPermission")));
            return true;
        }

        PunishmentGUI.getPlugin().reloadFiles();
        p.sendMessage(ChatColor.GREEN + "Config reloaded. Changes should be live in game.");
        return true;
    }

}
