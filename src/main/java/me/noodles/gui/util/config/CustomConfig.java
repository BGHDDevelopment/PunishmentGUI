package me.noodles.gui.util.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public final class CustomConfig implements IConfig {
    private FileConfiguration newConfig = null;
    private File configFile = null;
    private String configName;
    private JavaPlugin plugin;

    public CustomConfig(JavaPlugin plugin, String configName) {
        this.configName = configName;
        this.plugin = plugin;

        this.createConfig();
    }

    private void createConfig() {
        this.configFile = new File(this.plugin.getDataFolder(), this.configName);

        this.saveDefaultConfig();

        this.newConfig = new YamlConfiguration();

        try {
            this.newConfig.load(this.configFile);
        }  catch (IOException | InvalidConfigurationException e) {
            this.plugin.getLogger().severe(e.getMessage());
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        if (this.newConfig == null) this.reloadConfig();
        return this.newConfig;
    }

    public void reloadConfig() {
        this.newConfig = YamlConfiguration.loadConfiguration(this.configFile);

        final Reader configReader = new InputStreamReader(this.plugin.getResource(this.configName), StandardCharsets.UTF_8);

        final YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(configReader);

        this.newConfig.setDefaults(defaultConfig);
        this.newConfig.options().copyDefaults(true);
    }

    /**
     * Save config removes comments, use with caution.
     */
    @Deprecated
    public void saveConfig() {
        try {
            getConfig().save(this.configFile);
        } catch (IOException exception) {
            this.plugin.getLogger().warning(exception.getMessage());
        }
    }

    public void saveDefaultConfig() {
        if (this.configFile == null) { new File(this.plugin.getDataFolder(), this.configName); }
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            this.plugin.saveResource(this.configName, false);
        }
    }
}
