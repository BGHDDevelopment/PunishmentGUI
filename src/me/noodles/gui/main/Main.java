package me.noodles.gui.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.noodles.gui.commands.Punish;
import me.noodles.gui.inv.ClickEvents;
import me.noodles.gui.main.updatechecker.JoinExample;
import me.noodles.gui.main.updatechecker.UpdateChecker;

public class Main extends JavaPlugin
{
	private UpdateChecker checker;
    public static Main plugin;
    private static Main instance;
    
    
    private void setInstance(Main instance) {
        this.instance = instance;
    }
    
	
    public static Main getInstance() {
        return getInstance();
    }
    
    public static Plugin getPlugin2() {
        return Main.plugin;
    }
    
    public static Main getPlugin() {
        return (Main)JavaPlugin.getPlugin((Class)Main.class);
    }
    
    public void onEnable() {
    	PluginDescriptionFile VarUtilType = this.getDescription();
		this.getLogger().info("AdvancedBanGUI V" + VarUtilType.getVersion() + " starting...");
		this.getLogger().info("AdvancedBanGUI V" + VarUtilType.getVersion() + " loading commands and config files...");
        this.createFiles();
        this.registerEvents();
        this.registerCommands();
        plugin = this;
        this.setEnabled(true);
		getLogger().info("AdvancedBanGUI V" + VarUtilType.getVersion() + " started!");
		this.getLogger().info("AdvancedBanGUI V" + VarUtilType.getVersion() + " checking for updates...");
        this.checker = new UpdateChecker(this);
		if (this.checker.isConnected()) {
			if (this.checker.hasUpdate()) {
				getServer().getConsoleSender().sendMessage("------------------------");
				getServer().getConsoleSender().sendMessage("AdvancedBanGUI is outdated!");
				getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
				getServer().getConsoleSender().sendMessage("Your version: " + Main.plugin.getDescription().getVersion());
				getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/");
				getServer().getConsoleSender().sendMessage("------------------------");
			} else {
				getServer().getConsoleSender().sendMessage("------------------------");
				getServer().getConsoleSender().sendMessage("AdvancedBanGUI is up to date!");
				getServer().getConsoleSender().sendMessage("------------------------");
			}
		}
	}
    
    
    public void registerEvents() {
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Punish(null), this);
        pm.registerEvents(new ClickEvents(), this);
        pm.registerEvents(new JoinExample(), this);
    }
    public void registerCommands() {
    	this.getCommand("punish").setExecutor(new Punish(null));

    }
    
    private File configf, guiitems, banreason;
    private FileConfiguration config, guiitems1, banreason1;


    public FileConfiguration getguiitems1Config() {
        return this.guiitems1;
    }

    public FileConfiguration getbanreason1Config() {
        return this.banreason1;
    }
    
    
    private void createFiles() {
        configf = new File(getDataFolder(), "config.yml");
        guiitems = new File(getDataFolder(), "guiitems.yml");
        banreason = new File(getDataFolder(), "banreason.yml");

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

        config = new YamlConfiguration();
        guiitems1 = new YamlConfiguration();
        banreason1 = new YamlConfiguration();
        try {
            config.load(configf);
            guiitems1.load(guiitems);
            banreason1.load(banreason);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public void loadConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }
    
}
