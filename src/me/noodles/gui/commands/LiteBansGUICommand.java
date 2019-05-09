package me.noodles.gui.commands;

import me.noodles.gui.Settings;
import me.noodles.gui.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LiteBansGUICommand implements Listener, CommandExecutor {


	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getServer().getLogger().warning(Main.plugin.getConfig().getString("NoPlayer"));
			return true;
		}
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("litebansgui")) {
			return true;
		}
		p.sendMessage(ChatColor.GRAY +  "****************************************************");
		p.sendMessage(ChatColor.GOLD +  "Created by: " + ChatColor.WHITE + "" + Settings.DEVELOPER_NAME);
		p.sendMessage(ChatColor.GOLD +  "Website: " + ChatColor.WHITE + "" + Settings.DEVELOPER_URL);
		p.sendMessage(ChatColor.GOLD +  "Spigot Link: " + ChatColor.WHITE + "" + Settings.PLUGIN_URL);
		p.sendMessage(ChatColor.GOLD +  "Support Link: " + ChatColor.WHITE + "" + Settings.SUPPORT_DISCORD_URL);
		p.sendMessage(ChatColor.GRAY +  "****************************************************");
		return true;
	}

}