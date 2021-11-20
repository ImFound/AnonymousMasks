package dev.imfound.anonymousmasks.utils;

import dev.imfound.anonymousmasks.config.enums.Config;
import org.bukkit.inventory.ItemStack;

public class MaskUtils {

    public static boolean isMask(ItemStack i) {
        return i.getType() == Config.ITEM_MATERIAL.getMaterial() && i.getItemMeta().getDisplayName().equals(Config.ITEM_DISPLAYNAME.getFormattedString());
    }

}
