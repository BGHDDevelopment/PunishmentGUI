package me.noodles.gui.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.noodles.gui.inv.InvCreator;
import me.noodles.gui.inv.InvNames;
import me.noodles.gui.inv.Items;
import me.noodles.gui.PunishmentGUI;

public class Punish implements Listener, CommandExecutor {

	public static String bannedPlayer;

	public Punish() {
		this.bannedPlayer = null;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getServer().getLogger().warning(PunishmentGUI.plugin.getConfig().getString("NoPlayer"));
			return true;
		}
		Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("punish")) {
			return true;
		}
		if (args.length < 1) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("NoMessage")));
			return true;
		}
		if (args.length == 1) {
			bannedPlayer = args[0];
		}
		if (!sender.hasPermission("punish.use")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("NoPermission")));
			return true;
		}
		if (args.length > 1) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("NoMessage")));
			return true;
		}
		if(bannedPlayer.length() > 16){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("NameLength")));
			return true;
		}
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("ChatOffensesLocation"), Items.ChatOffences(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("GeneralOffensesLocation"), Items.GeneralOffences(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("ClientModOffensesLocation"), Items.ClientModOffences(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity1MuteLocation"), Items.Severity1Mute(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity1GeneralBanLocation"), Items.Severity1GeneralBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity1ClientBanLocation"), Items.Severity1ClientBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("PermanentMuteLocation"), Items.PermMute(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity2MuteLocation"), Items.Severity2Mute(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity2ClientBanLocation"), Items.Severity2ClientBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("PermanentBanLocation"), Items.PermBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity3MuteLocation"), Items.Severity3Mute(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("Severity3ClientBanLocation"), Items.Severity3ClientBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("IPBanLocation"), Items.IPBan(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("IPMuteLocation"), Items.IPMute(p));
		InvCreator.Main.setItem(PunishmentGUI.plugin.getguiitems1Config().getInt("WarningLocation"), Items.Warning(p));
		if (PunishmentGUI.plugin.getguiitems1Config().getBoolean("FillerEnabled") == true) {
			for (int i = 0; i < 54; ++i) {
				if (InvCreator.Main.getItem(i) == null) {
					InvCreator.Main.setItem(i, Items.Glass(p));
				}
			}
		}
		p.openInventory(InvCreator.Main);
		return true;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getView().getTitle().equals(null)) {
			return;
		}
		if (e.getCurrentItem() == null || (e.getCurrentItem().getType() == Material.AIR)) {
			return;
		}
		if (e.getView().getTitle().equals(InvNames.Main)) {
			e.setCancelled(true);
			if (e.getCurrentItem().equals(Items.PermMute(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("PermMuteCommand").replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("PermMuteReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("PermMuteMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity1Mute(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity1MuteCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1MuteTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1MuteReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity1MuteMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity1GeneralBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity1GeneralBanCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1GeneralBanTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1GeneralBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity1GeneralBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity1ClientBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity1ClientBanCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1ClientBanTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity1ClientBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity1ClientBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity2Mute(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity2MuteCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity2MuteTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity2MuteReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity2MuteMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity3Mute(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity3MuteCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity3MuteTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity3MuteReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity3MuteMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity2ClientBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity2ClientBanCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity2ClientBanTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity2ClientBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity2ClientBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Severity3ClientBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("Severity3ClientBanCommand").replace("%t%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity3ClientBanTime")).replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("Severity3ClientBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("Severity3ClientBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.PermBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("PermBanCommand").replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("PermBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("PermBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.IPMute(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("IPMuteCommand").replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("IPMuteReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("IPMuteMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.IPBan(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("IPBanCommand").replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("IPBanReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("IPBanMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
			if (e.getCurrentItem().equals(Items.Warning(p))) {
				p.chat(PunishmentGUI.plugin.getguicommands1Config().getString("WarnCommand").replace("%reason%", PunishmentGUI.plugin.getbanreason1Config().getString("WarnReason")).replace("%target%", bannedPlayer));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PunishmentGUI.plugin.getConfig().getString("Prefix") + PunishmentGUI.plugin.getbanreason1Config().getString("WarnMessage").replace("%player%", bannedPlayer)));
				p.closeInventory();
			}
		}
	}

}

