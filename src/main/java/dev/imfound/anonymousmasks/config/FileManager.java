package dev.imfound.anonymousmasks.config;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    private File dataFolder;
    private JavaPlugin plugin;
    @Getter static FileConfiguration langConfiguration;
    @Getter static FileConfiguration configuration;

    public FileManager(File dataFolder, JavaPlugin plugin) {
        this.dataFolder = dataFolder;
        this.plugin = plugin;
        createConfigs();
    }


    private void createConfigs() {
        File langFile = new File(dataFolder, "lang.yml");
        if(!langFile.exists()) {
            langFile.getParentFile().mkdirs();
            plugin.saveResource("lang.yml", false);
        }
        FileConfiguration langConfig = new YamlConfiguration();
        File configFile = new File(dataFolder, "config.yml");
        if(!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource("config.yml", false);
        }
        FileConfiguration yamlConfiguration = new YamlConfiguration();
        try{
            yamlConfiguration.load(configFile);
            langConfig.load(langFile);
            langConfiguration = langConfig;
            configuration = yamlConfiguration;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


}
