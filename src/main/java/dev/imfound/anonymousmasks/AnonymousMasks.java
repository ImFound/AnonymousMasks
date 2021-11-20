package dev.imfound.anonymousmasks;

import dev.imfound.anonymousmasks.commands.CommandManager;
import dev.imfound.anonymousmasks.config.FileManager;
import dev.imfound.anonymousmasks.config.enums.Config;
import dev.imfound.anonymousmasks.events.EventManager;
import dev.imfound.anonymousmasks.utils.DependsUtils;
import dev.imfound.anonymousmasks.utils.Log;
import dev.imfound.anonymousmasks.utils.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnonymousMasks extends JavaPlugin {



    @Override
    public void onEnable() {
        Log.info("--[AnonymousMasks v5.0]--");
        long startTime = System.currentTimeMillis();
        Log.info("Loading configs...");
        new FileManager(getDataFolder(), this);
        Log.info("Configs loaded!");
        Log.info("Checking method..");
        if(DependsUtils.hasTab()) {
            Log.info("TAB found!");
        } else {
          if(Config.METHOD.getString().equalsIgnoreCase("TAB")) {
                Log.error("TAB NOT FOUND! ABORTING START!");
                Bukkit.getPluginManager().getPlugin("AnonymousMasks").onDisable();
                return;
            }
        }
        Log.info("Methods checked!");
        Log.info("Registering commands...");
        new CommandManager(this);
        Log.info("Commands registered!");
        Log.info("Loading listeners...");
        new EventManager(this);
        Log.info("Listeners loaded!");
        Log.info("Loading bStats...");
        new Metrics(this, 13312);
        Log.info("bStats loaded!");
        long endTime = System.currentTimeMillis() - startTime;
        Log.info("Plugin loaded in " + endTime + "ms");
        Log.info("--[AnonymousMasks v5.0]--");
    }

    @Override
    public void onDisable() {

    }


}
