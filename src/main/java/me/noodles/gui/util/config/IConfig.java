package me.noodles.gui.util.config;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfig {
    public FileConfiguration getConfig();
    public void reloadConfig();
    public void saveConfig();
    public void saveDefaultConfig();
}
