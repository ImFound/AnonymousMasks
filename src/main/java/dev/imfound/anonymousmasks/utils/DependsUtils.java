package dev.imfound.anonymousmasks.utils;

import org.bukkit.Bukkit;

public class DependsUtils {

    public static boolean hasTab() {
        return Bukkit.getPluginManager().getPlugin("TAB") != null;
    }

}
