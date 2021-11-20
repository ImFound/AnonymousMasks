package dev.imfound.anonymousmasks.config.enums;

import dev.imfound.anonymousmasks.config.FileManager;
import net.md_5.bungee.api.ChatColor;

import java.util.List;

public enum Lang {

   PREFIX(".prefix"),
   NO_PERMS(".Messages.no-perms"),
   HELP(".Messages.help"),
   HELP_CONSOLE(".Messages.help_console"),
   MASK_GETTED(".Messages.mask-getted"),
   MASK_GIVED(".Messages.mask-gived"),
   MASK_NOT_ONLINE(".Messages.not-online"),
   HEAD_ERROR(".Mask.head-error");

    private final String path;

    Lang(String path) {
        this.path = path;
    }

    public boolean getBoolean() {
        return FileManager.getLangConfiguration().getBoolean(path);
    }

    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', FileManager.getLangConfiguration().getString(path));
    }

    public String getString() {
        return FileManager.getLangConfiguration().getString(path);
    }

    public int getInt() {
        return FileManager.getLangConfiguration().getInt(path);
    }

    public List<String> getStringList() {
        return FileManager.getLangConfiguration().getStringList(path);
    }

    public static String getFormattedString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
