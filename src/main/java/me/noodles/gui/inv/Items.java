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
        List<String> _item = Lists.newArrayList(PunishmentGUI.plugin.getguiitems1Config().getString("GUIFillerItem", "STAINED_GLASS_PANE:7").split(":"));
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
            PunishmentGUI.plugin.getguiitems1Config().getString("ClientModOffensesItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("ClientModOffensesName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("ClientModOffensesLore")
        );
    }
    
    public static ItemStack GeneralOffences(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("GeneralOffensesItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("GeneralOffensesName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("GeneralOffensesLore")
        );
    }
    
    public static ItemStack ChatOffences(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("ChatOffensesItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("ChatOffensesName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("ChatOffensesLore")
        );
    }
    
    
    public static ItemStack PermMute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("PermanentMuteItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("PermanentMuteName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("PermanentMuteLore")
        );
    }
    public static ItemStack PermBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("PermanentBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("PermanentBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("PermanentBanLore")
        );
    }

    public static ItemStack IPBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("IPBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("IPBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("IPBanLore")
        );
    }
    public static ItemStack IPMute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("IPMuteItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("IPMuteName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("IPMuteLore")
        );
    }
    
    public static ItemStack Severity1Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1MuteItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1MuteName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity1MuteLore")
        );
    }

    public static ItemStack Warning(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("WarningItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("WarningName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("WarningLore")
        );
    }
    
    public static ItemStack Severity1GeneralBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1GeneralBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1GeneralBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity1GeneralBanLore")
        );
    }
    
    public static ItemStack Severity1ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1ClientBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity1ClientBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity1ClientBanLore")
        );

    }
    public static ItemStack Severity2Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity2MuteItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity2MuteName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity2MuteLore")
        );
    }
    public static ItemStack Severity2ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity2ClientBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity2ClientBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity2ClientBanLore")
        );
    }
    public static ItemStack Severity3Mute(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity3MuteItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity3MuteName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity3MuteLore")
        );
    }
    public static ItemStack Severity3ClientBan(Player p) {
        return createItemFromConfig(
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity3ClientBanItem"),
            PunishmentGUI.plugin.getguiitems1Config().getString("Severity3ClientBanName"),
            PunishmentGUI.plugin.getguiitems1Config().getStringList("Severity3ClientBanLore")
        );
    }
    
}
