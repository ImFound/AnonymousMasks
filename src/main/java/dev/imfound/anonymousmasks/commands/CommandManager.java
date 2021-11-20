package dev.imfound.anonymousmasks.commands;

import dev.imfound.anonymousmasks.AnonymousMasks;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    private JavaPlugin plugin;

    public CommandManager(AnonymousMasks plugin) {
        this.plugin = plugin;
        plugin.getCommand("anonymousmasks").setExecutor(new AnonymousMasksCommand(plugin));
    }

}
