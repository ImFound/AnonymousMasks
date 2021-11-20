package dev.imfound.anonymousmasks.config;

import com.google.common.base.Charsets;
import dev.imfound.anonymousmasks.AnonymousMasks;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Files {


    public static FileManager LANG = new FileManager("lang", AnonymousMasks.getInstance());
    public static FileManager SETTINGS = new FileManager("settings", AnonymousMasks.getInstance());

    public static void reload(String fileName, FileManager fileManager) {
        File file = new File(AnonymousMasks.getInstance().getDataFolder(), fileName + ".yml");
        FileConfiguration yamlConfiguration = new YamlConfiguration();
        try{
            yamlConfiguration.load(file);
            fileManager.setConfiguration(yamlConfiguration);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
