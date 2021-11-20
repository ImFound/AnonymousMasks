package dev.imfound.anonymousmasks.config;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    private final String fileName;
    private String customFolder;
    private final JavaPlugin plugin;
    @Getter public FileConfiguration configuration;

    public FileManager(String fileName, JavaPlugin plugin) {
        this.fileName = fileName;
        this.plugin = plugin;
        init();
    }

    public FileManager(String fileName, String customFolder, JavaPlugin plugin) {
        this.fileName = fileName;
        this.customFolder = customFolder;
        this.plugin = plugin;
        init();
    }

    private void init() {
        File file = new File(plugin.getDataFolder() + (customFolder != null ? "/" + customFolder : ""),  fileName + ".yml");
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(fileName + ".yml", false);
        }

        FileConfiguration yamlConfiguration = new YamlConfiguration();
        try{
            yamlConfiguration.load(file);
            configuration = yamlConfiguration;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


}
