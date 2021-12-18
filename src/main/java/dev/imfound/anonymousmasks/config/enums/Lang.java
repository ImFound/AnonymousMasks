package dev.imfound.anonymousmasks.config.enums;

import dev.imfound.anonymousmasks.config.FileManager;
import dev.imfound.anonymousmasks.config.Files;
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
   HEAD_ERROR(".Mask.head-error"),
   RELOADED(".Messages.reload"),
    RIGHT_CLICK(".Messages.right-click");

    private final String path;

    Lang(String path) {
        this.path = path;
    }

    public boolean getBoolean() {
        return Files.LANG.getConfiguration().getBoolean(path);
    }

    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', Files.LANG.getConfiguration().getString(path));
    }

    public String getString() {
        return Files.LANG.getConfiguration().getString(path);
    }

    public int getInt() {
        return Files.LANG.getConfiguration().getInt(path);
    }

    public List<String> getStringList() {
        return Files.LANG.getConfiguration().getStringList(path);
    }

    public static String getFormattedString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
