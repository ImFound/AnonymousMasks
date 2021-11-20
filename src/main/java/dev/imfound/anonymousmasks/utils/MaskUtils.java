package dev.imfound.anonymousmasks.utils;

import de.tr7zw.nbtapi.NBTItem;
import dev.imfound.anonymousmasks.config.enums.Settings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    public static void giveMask(Player p) {
        ItemStack mask = new ItemStack(Settings.ITEM_MATERIAL.getMaterial());
        ItemMeta mMeta = mask.getItemMeta();
        mMeta.setDisplayName(Settings.ITEM_DISPLAYNAME.getFormattedString());
        mMeta.setLore(Settings.ITEM_LORE.getStringList());
        mask.setItemMeta(mMeta);
        NBTItem nbtItem = new NBTItem(mask);
        nbtItem.setBoolean("mask", true);
        nbtItem.applyNBT(mask);
        p.getInventory().addItem(mask);
    }


}
