package me.noodles.gui;

import me.noodles.gui.commands.PunishmentGUICommand;
import me.noodles.gui.commands.PunishmentGUIReloadCommand;
import me.noodles.gui.listeners.LeaveEvent;
import me.noodles.gui.manager.BannedManager;
import me.noodles.gui.util.config.CustomConfig;
import me.noodles.gui.util.config.IConfig;
import me.noodles.gui.util.Logger;
import me.noodles.gui.util.MetricsLite;
import me.noodles.gui.util.Settings;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.noodles.gui.commands.Punish;
import me.noodles.gui.listeners.JoinEvents;
import me.noodles.gui.updatechecker.UpdateChecker;

public class PunishmentGUI extends JavaPlugin {
    private static PunishmentGUI plugin;

    private IConfig customConfig, guiConfig, banConfig, guiCommands;
    private BannedManager bannedPlayersManager = BannedManager.getManager();

    public void onEnable() {
        this.createFiles();
        if (getConfig().getBoolean("SilentStart.Enabled")) {
            plugin = this;
            MetricsLite metrics = new MetricsLite(this);
            this.registerEvents();
            this.registerCommands();
            this.setEnabled(true);
            Logger.log(Logger.LogLevel.SUCCESS, "PunishmentGUI Version: " + Settings.VERSION + " Loaded.");
            if (getConfig().getBoolean("CheckForUpdates.Enabled")) {
                new UpdateChecker(this, 52072).getLatestVersion(version -> {
                    if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                        Logger.log(Logger.LogLevel.SUCCESS, ("PunishmentGUI is up to date!"));
                    } else {
                        Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                        Logger.log(Logger.LogLevel.WARNING, ("PunishmentGUI is outdated!"));
                        Logger.log(Logger.LogLevel.WARNING, ("Newest version: " + version));
                        Logger.log(Logger.LogLevel.WARNING, ("Your version: " + Settings.VERSION));
                        Logger.log(Logger.LogLevel.WARNING, ("Please Update Here: " + Settings.PLUGIN_URL));
                        Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                    }
                });
            }
        } else {
            Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            Logger.log(Logger.LogLevel.INFO, "Initializing PunishmentGUI Version: " + Settings.VERSION);
            Logger.log(Logger.LogLevel.INFO, "Created by: " + Settings.DEVELOPER_NAME);
            Logger.log(Logger.LogLevel.INFO, "Website: " + Settings.DEVELOPER_URL);
            Logger.log(Logger.LogLevel.INFO, "Spigot: " + Settings.PLUGIN_URL);
            Logger.log(Logger.LogLevel.INFO, "Support: " + Settings.SUPPORT_DISCORD_URL);
            Logger.log(Logger.LogLevel.INFO, "Suggestions/Feedback: " + Settings.FEEDBACK);
            Logger.log(Logger.LogLevel.INFO, "Wiki: " + Settings.WIKI);
            Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            Logger.log(Logger.LogLevel.INFO, "Plugin Loading...");
            Logger.log(Logger.LogLevel.INFO, "Registering Managers...");
            plugin = this;
            MetricsLite metrics = new MetricsLite(this);
            Logger.log(Logger.LogLevel.INFO, "Managers Registered!");
            Logger.log(Logger.LogLevel.INFO, "Loading Config's...");
            this.createFiles();
            Logger.log(Logger.LogLevel.INFO, "Config's Registered!");
            Logger.log(Logger.LogLevel.INFO, "Registering Listeners...");
            this.registerEvents();
            Logger.log(Logger.LogLevel.INFO, "Listeners Registered!");
            Logger.log(Logger.LogLevel.INFO, "Registering Commands...");
            this.registerCommands();
            Logger.log(Logger.LogLevel.INFO, "Commands Registered!");
            Logger.log(Logger.LogLevel.SUCCESS, "PunishmentGUI Version: " + Settings.VERSION + " Loaded.");
            this.setEnabled(true);
            Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            if (getConfig().getBoolean("CheckForUpdates.Enabled")) {
                Logger.log(Logger.LogLevel.INFO, "Checking for updates...");
                new UpdateChecker(this, 52072).getLatestVersion(version -> {
                    if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                        Logger.log(Logger.LogLevel.SUCCESS, ("PunishmentGUI is up to date!"));
                    } else {
                        Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                        Logger.log(Logger.LogLevel.WARNING, ("PunishmentGUI is outdated!"));
                        Logger.log(Logger.LogLevel.WARNING, ("Newest version: " + version));
                        Logger.log(Logger.LogLevel.WARNING, ("Your version: " + Settings.VERSION));
                        Logger.log(Logger.LogLevel.WARNING, ("Please Update Here: " + Settings.PLUGIN_URL));
                        Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                    }
                });
            }
        }
    }

    @Override
    public void onDisable() {
        getBannedManager().clear();
    }

    public void registerEvents() {
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Punish(), this);
        pm.registerEvents(new JoinEvents(), this);
        pm.registerEvents(new LeaveEvent(), this);
    }

    public void registerCommands() {
        this.getCommand("punish").setExecutor(new Punish());
        this.getCommand("punishmentgui").setExecutor(new PunishmentGUICommand());
        this.getCommand("punishmentguireload").setExecutor(new PunishmentGUIReloadCommand());
    }

    @Override
    public FileConfiguration getConfig() { return this.customConfig.getConfig(); }
    public FileConfiguration getGuiItems() { return this.guiConfig.getConfig(); }
    public FileConfiguration getBanReason() {
        return this.banConfig.getConfig();
    }
    public FileConfiguration getGuiCommands() {
        return this.guiCommands.getConfig();
    }

    public void reloadFiles() {
        this.customConfig.reloadConfig();
        this.guiConfig.reloadConfig();
        this.banConfig.reloadConfig();
        this.guiCommands.reloadConfig();
    }

    public static PunishmentGUI getPlugin() { return plugin; }

    private void createFiles() {
        customConfig = new CustomConfig(this, "config.yml");
        guiConfig = new CustomConfig(this, "guiitems.yml");
        banConfig = new CustomConfig(this, "banreason.yml");
        guiCommands = new CustomConfig(this, "guicommands.yml");
    }

    public BannedManager getBannedManager() { return this.bannedPlayersManager; }

}
