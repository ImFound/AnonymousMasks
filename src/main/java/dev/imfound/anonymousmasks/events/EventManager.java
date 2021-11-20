package dev.imfound.anonymousmasks.events;

import dev.imfound.anonymousmasks.events.listeners.InventoryClick;
import dev.imfound.anonymousmasks.events.listeners.PlayerChat;
import dev.imfound.anonymousmasks.events.listeners.PlayerInteract;
import dev.imfound.anonymousmasks.events.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

    private JavaPlugin plugin;

    public EventManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new PlayerChat(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerInteract(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoin(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InventoryClick(), plugin);
    }

}
