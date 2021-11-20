package dev.imfound.anonymousmasks.utils;

import de.tr7zw.nbtapi.NBTItem;
import dev.imfound.anonymousmasks.config.enums.Config;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaskUtils {

    public static boolean isMask(ItemStack i) {
        if(i != null && i.getType() != Material.AIR && i.getItemMeta() != null && i.getItemMeta().hasDisplayName()) {
            if(new NBTItem(i).hasNBTData() && new NBTItem(i).getBoolean("mask") != null) {
                NBTItem item = new NBTItem(i);
                return item.getBoolean("mask");
            }
        }
        return false;
    }

}
