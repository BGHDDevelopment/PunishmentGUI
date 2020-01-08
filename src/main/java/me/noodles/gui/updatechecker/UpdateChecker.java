package me.noodles.gui.updatechecker;

import java.net.*;

import me.noodles.gui.PunishmentGUI;
import me.noodles.gui.util.Settings;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker
{
    private PunishmentGUI plugin;
    private int resourceId;

    public UpdateChecker(PunishmentGUI plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().info("Cannot look for updates: " + exception.getMessage());
            }
        });
    }
}
