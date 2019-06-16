package me.noodles.gui.commands;

import me.noodles.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LiteBansGUIReloadCommand implements Listener, CommandExecutor {


	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getServer().getLogger().warning(Main.plugin.getConfig().getString("NoPlayer"));
			return true;
		}
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("litebansguireload")) {
			return true;
		}
		if (!sender.hasPermission("punish.reload")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("NoPermission")));
			return true;
		}
		Main.plugin.reloadFiles();
		p.sendMessage(ChatColor.GREEN + "Config reloaded. Changes should be live in game.");
		return true;
	}




}