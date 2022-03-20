package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.config.enums.Settings;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(MaskUtils.isMask(e.getEntity().getInventory().getHelmet())) {
            if(Settings.METHOD.getString().equalsIgnoreCase("TAB")) {
                NametagUtils.showNametagTab(e.getEntity());
            } else if(Settings.METHOD.getString().equalsIgnoreCase("Native")) {
                NametagUtils.showNametagNative(e.getEntity());
            } else if(Settings.METHOD.getString().equalsIgnoreCase("ArmorStand")){
                NametagUtils.showNametagArmorStand(e.getEntity());
            }
        }
    }

}
