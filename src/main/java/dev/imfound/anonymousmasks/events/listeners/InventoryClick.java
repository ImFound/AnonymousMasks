package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.config.enums.Settings;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getCurrentItem() != null && MaskUtils.isMask(e.getCurrentItem()) && e.getSlotType() == InventoryType.SlotType.ARMOR) {
            if(Settings.METHOD.getString().equalsIgnoreCase("TAB")) {
                NametagUtils.showNametagTab(p);
            } else if(Settings.METHOD.getString().equalsIgnoreCase("Native")) {
                NametagUtils.showNametagNative(p);
            } else if(Settings.METHOD.getString().equalsIgnoreCase("ArmorStand")){
                NametagUtils.showNametagArmorStand(p);
            }
        }
    }

}
