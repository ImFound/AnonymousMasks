package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.utils.MaskUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import static dev.imfound.anonymousmasks.utils.MaskUtils.giveMask;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if(MaskUtils.isMask(e.getPlayer().getInventory().getHelmet())) {
            e.getPlayer().getInventory().getHelmet().setAmount(1);
            giveMask(e.getPlayer());
        }
    }

}
