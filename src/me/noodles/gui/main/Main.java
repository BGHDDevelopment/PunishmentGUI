package me.noodles.gui.main;

import java.io.File;
import java.io.IOException;
import me.noodles.gui.Logger;
import me.noodles.gui.MetricsLite;
import me.noodles.gui.Settings;
import me.noodles.gui.commands.LiteBansGUICommand;
import me.noodles.gui.commands.LiteBansGUIReloadCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.noodles.gui.commands.Punish;
import me.noodles.gui.main.updatechecker.JoinEvents;
import me.noodles.gui.main.updatechecker.UpdateChecker;

public class Main extends JavaPlugin
{
	private UpdateChecker checker;
    public static Main plugin;

    public void onEnable() {
    	PluginDescriptionFile VarUtilType = this.getDescription();
        Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
        Logger.log(Logger.LogLevel.INFO, "Initializing LiteBansGUI Version: " + Settings.VERSION);
        Logger.log(Logger.LogLevel.INFO, "Created by: " + Settings.DEVELOPER_NAME);
        Logger.log(Logger.LogLevel.INFO, "Website: " + Settings.DEVELOPER_URL);
        Logger.log(Logger.LogLevel.INFO, "Spigot Link: " + Settings.PLUGIN_URL);
        Logger.log(Logger.LogLevel.INFO, "Support Link: " + Settings.SUPPORT_DISCORD_URL);
        Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
        Logger.log(Logger.LogLevel.INFO, "Plugin Loading...");
        Logger.log(Logger.LogLevel.INFO, "Registering Managers...");
        plugin = this;
        MetricsLite metrics = new MetricsLite(this);
        Logger.log(Logger.LogLevel.INFO, "Managers Registered!");
        Logger.log(Logger.LogLevel.INFO, "Registering Listeners...");
        this.registerEvents();
        Logger.log(Logger.LogLevel.INFO, "Listeners Registered!");
        Logger.log(Logger.LogLevel.INFO, "Registering Commands...");
        this.registerCommands();
        Logger.log(Logger.LogLevel.INFO, "Commands Registered!");
        Logger.log(Logger.LogLevel.INFO, "Loading Config's...");
        this.createFiles();
        Logger.log(Logger.LogLevel.INFO, "Config's Registered!");
        Logger.log(Logger.LogLevel.SUCCESS, "LiteBansGUI Version: " + Settings.VERSION + " Loaded.");
        this.setEnabled(true);
        Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
        Logger.log(Logger.LogLevel.INFO, "Checking for updates...");
        this.checker = new UpdateChecker(this);
        if (this.checker.isConnected()) {
            if (this.checker.hasUpdate()) {
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING,("LiteBansGUI is outdated!"));
                Logger.log(Logger.LogLevel.WARNING,("Newest version: " + this.checker.getLatestVersion()));
                Logger.log(Logger.LogLevel.WARNING,("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING,("Please Update Here: " + Settings.PLUGIN_URL));
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
            }
            else {
                Logger.log(Logger.LogLevel.SUCCESS, "LiteBansGUI is up to date!");
            }
		}
	}
    
    public void registerEvents() {
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Punish(), this);
        pm.registerEvents(new JoinEvents(), this);
    }
    public void registerCommands() {
        this.getCommand("punish").setExecutor(new Punish());
        this.getCommand("litebansgui").setExecutor(new LiteBansGUICommand());
        this.getCommand("litebansguireload").setExecutor(new LiteBansGUIReloadCommand());

    }
    
    private File configf, guiitems, banreason, guicommands;
    private FileConfiguration config, guiitems1, banreason1, guicommands1;
    public FileConfiguration getguiitems1Config() {
        return this.guiitems1;
    }
    public FileConfiguration getbanreason1Config() {
        return this.banreason1;
    }
    public FileConfiguration getguicommands1Config() {
        return this.guicommands1;
    }

    public void reloadFiles() {
        config = YamlConfiguration.loadConfiguration(configf);
        guiitems1 = YamlConfiguration.loadConfiguration(guiitems);
        banreason1 = YamlConfiguration.loadConfiguration(banreason);
        guicommands1 = YamlConfiguration.loadConfiguration(guicommands);

    }

    private void createFiles() {
        configf = new File(getDataFolder(), "config.yml");
        guiitems = new File(getDataFolder(), "guiitems.yml");
        banreason = new File(getDataFolder(), "banreason.yml");
        guicommands = new File(getDataFolder(), "guicommands.yml");

        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        if (!guiitems.exists()) {
            guiitems.getParentFile().mkdirs();
            saveResource("guiitems.yml", false);
         }
        if (!banreason.exists()) {
            banreason.getParentFile().mkdirs();
            saveResource("banreason.yml", false);
         }
        if (!guicommands.exists()) {
            guicommands.getParentFile().mkdirs();
            saveResource("guicommands.yml", false);
        }
        config = new YamlConfiguration();
        guiitems1 = new YamlConfiguration();
        banreason1 = new YamlConfiguration();
        guicommands1 = new YamlConfiguration();

        try {
            config.load(configf);
            guiitems1.load(guiitems);
            banreason1.load(banreason);
            guicommands1.load(guicommands);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
}
