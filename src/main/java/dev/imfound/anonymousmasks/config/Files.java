package dev.imfound.anonymousmasks.config;

import dev.imfound.anonymousmasks.AnonymousMasks;

public class Files {

    public static FileManager LANG = new FileManager("lang", AnonymousMasks.getInstance());
    public static FileManager SETTINGS = new FileManager("settings", AnonymousMasks.getInstance());

}
