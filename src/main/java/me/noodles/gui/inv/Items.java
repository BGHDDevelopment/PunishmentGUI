package me.noodles.gui.inv;

import java.util.List;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.noodles.gui.PunishmentGUI;

public class Items {

    public static ItemStack Glass(Player p) {
        List<String> _item = Lists.newArrayList(PunishmentGUI.getPlugin().getGuiItems().getString("GUIFillerItem", "STAINED_GLASS_PANE:7").split(":"));
        if (_item.size() == 1) _item.add(String.valueOf(0));
        ItemStack itemStack = new ItemStack(Material.getMaterial(_item.get(0)), 1, Short.parseShort(_item.get(1)));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private static String getColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    private static ItemStack createItemFromConfig(String item, String name, List<String> lore) {
        List<String> _item = Lists.newArrayList(item.split(":"));
        if (_item.size() == 1) _item.add(String.valueOf(0));
        ItemStack _itemStack = new ItemStack(Material.getMaterial(_item.get(0)), 1, Short.parseShort(_item.get(1)));
        ItemMeta _itemMeta = _itemStack.getItemMeta();
        _itemMeta.setDisplayName(getColor(name));
        lore.replaceAll(Items::getColor);
        _itemMeta.setLore(lore);
        _itemStack.setItemMeta(_itemMeta);
        return _itemStack;
    }

    public static ItemStack ClientModOffences(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("ClientModOffensesItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("ClientModOffensesName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("ClientModOffensesLore")
        );
    }

    public static ItemStack GeneralOffences(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("GeneralOffensesItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("GeneralOffensesName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("GeneralOffensesLore")
        );
    }

    public static ItemStack ChatOffences(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("ChatOffensesItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("ChatOffensesName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("ChatOffensesLore")
        );
    }

    public static ItemStack PermMute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("PermanentMuteItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("PermanentMuteName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("PermanentMuteLore")
        );
    }

    public static ItemStack PermBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("PermanentBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("PermanentBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("PermanentBanLore")
        );
    }

    public static ItemStack IPBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("IPBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("IPBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("IPBanLore")
        );
    }

    public static ItemStack IPMute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("IPMuteItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("IPMuteName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("IPMuteLore")
        );
    }

    public static ItemStack Severity1Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1MuteItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1MuteName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity1MuteLore")
        );
    }

    public static ItemStack Warning(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("WarningItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("WarningName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("WarningLore")
        );
    }

    public static ItemStack Severity1GeneralBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1GeneralBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1GeneralBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity1GeneralBanLore")
        );
    }

    public static ItemStack Severity1ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1ClientBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity1ClientBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity1ClientBanLore")
        );

    }

    public static ItemStack Severity2Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity2MuteItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity2MuteName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity2MuteLore")
        );
    }

    public static ItemStack Severity2ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity2ClientBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity2ClientBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity2ClientBanLore")
        );
    }

    public static ItemStack Severity3Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity3MuteItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity3MuteName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity3MuteLore")
        );
    }

    public static ItemStack Severity3ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity3ClientBanItem"),
            PunishmentGUI.getPlugin().getGuiItems().getString("Severity3ClientBanName"),
            PunishmentGUI.getPlugin().getGuiItems().getStringList("Severity3ClientBanLore")
        );
    }

}
