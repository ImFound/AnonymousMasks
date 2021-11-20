package dev.imfound.anonymousmasks.utils;

import java.util.logging.Logger;

public class Log {

    private static final Logger logger = Logger.getLogger("Minecraft");

    public static void info(String s) {
        logger.info("[AnonymousMasks] " + s);
    }

    public static void warn(String s) {
        logger.warning("[AnonymousMasks] " + s);
    }

    public static void error(String s) {
        logger.severe("[AnonymousMasks] " + s);
    }

    public static void fine(String s) {
        logger.fine("[AnonymousMasks] " + s);
    }

}
