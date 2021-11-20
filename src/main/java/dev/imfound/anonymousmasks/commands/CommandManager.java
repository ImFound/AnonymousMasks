package dev.imfound.anonymousmasks.commands;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    private JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getCommand("anonymousmasks").setExecutor(new AnonymousMasksCommand());
    }

}
