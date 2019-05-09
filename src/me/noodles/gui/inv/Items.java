package me.noodles.gui.inv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.noodles.gui.main.Main;

public class Items {

    public static ItemStack Glass(Player p) {
        ItemStack stone = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(" ");
        stone.setItemMeta(stonem);
        return stone;
    }
	
    
    private static String getColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    
    public static ItemStack ClientModOffences(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("ClientModOffensesItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("ClientModOffensesName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("ClientModOffensesLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    public static ItemStack GeneralOffences(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("GeneralOffensesItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("GeneralOffensesName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("GeneralOffensesLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    public static ItemStack ChatOffences(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("ChatOffensesItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("ChatOffensesName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("ChatOffensesLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    
    public static ItemStack PermMute(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("PermanentMuteItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("PermanentMuteName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("PermanentMuteLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack PermBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("PermanentBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("PermanentBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("PermanentBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }

    public static ItemStack IPBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("IPBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("IPBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("IPBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack IPMute(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("IPMuteItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("IPMuteName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("IPMuteLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    public static ItemStack Severity1Mute(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity1MuteItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity1MuteName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity1MuteLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }

    public static ItemStack Warning(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("WarningItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("WarningName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("WarningLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    public static ItemStack Severity1GeneralBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity1GeneralBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity1GeneralBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity1GeneralBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
    public static ItemStack Severity1ClientBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity1ClientBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity1ClientBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity1ClientBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack Severity2Mute(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity2MuteItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity2MuteName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity2MuteLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack Severity2ClientBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity2ClientBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity2ClientBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity2ClientBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack Severity3Mute(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity3MuteItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity3MuteName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity3MuteLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    public static ItemStack Severity3ClientBan(Player p) {
        ItemStack stone = new ItemStack(Material.getMaterial(Main.plugin.getguiitems1Config().getString("Severity3ClientBanItem")));
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.plugin.getguiitems1Config().getString("Severity3ClientBanName")));
        ArrayList<String> lore = new ArrayList<>();
        List<String> stringList = Main.plugin.getguiitems1Config().getStringList("Severity3ClientBanLore");
        IntStream.range(0, stringList.size()).forEach(i -> lore.add(getColor(stringList.get(i))));
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }
    
}
