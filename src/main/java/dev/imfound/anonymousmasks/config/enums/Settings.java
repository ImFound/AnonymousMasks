package dev.imfound.anonymousmasks.config.enums;

import dev.imfound.anonymousmasks.config.FileManager;
import dev.imfound.anonymousmasks.config.Files;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

import java.util.List;

public enum Settings {

    ITEM_DISPLAYNAME("item.displayname"),
    ITEM_MATERIAL("item.material"),
    ITEM_LORE("item.lore"),
    METHOD("method"),
    CHAT_DISTANCE_ENABLED("Chat.chat-distance.enabled"),
    CHAT_DISTANCE_DISTANCE("Chat.chat-distance.distance"),
    FORMAT("Chat.format");

    private final String path;

    Settings(String path) {
        this.path = path;
    }

    public boolean getBoolean() {
        return Files.SETTINGS.getConfiguration().getBoolean(path);
    }

    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', Files.SETTINGS.getConfiguration().getString(path));
    }

    public Material getMaterial() {
        return Material.getMaterial(Files.SETTINGS.getConfiguration().getString(path));
    }

    public String getString() {
        return Files.SETTINGS.getConfiguration().getString(path);
    }

    public int getInt() {
        return Files.SETTINGS.getConfiguration().getInt(path);
    }

    public List<String> getStringList() {
        return Files.SETTINGS.getConfiguration().getStringList(path);
    }

    public static String getFormattedString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }


}
