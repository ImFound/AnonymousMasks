package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.config.enums.Config;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (!MaskUtils.isMask(p.getInventory().getHelmet())) return;
        e.setCancelled(true);
        if (Config.CHAT_DISTANCE_ENABLED.getBoolean()) {
            for (Player ps : Bukkit.getOnlinePlayers()) {
                if (ps.getLocation().distance(p.getLocation()) <= Config.CHAT_DISTANCE_DISTANCE.getInt()) {
                    ps.sendMessage(Config.FORMAT.getFormattedString().replace("%message%", e.getMessage()));
                }
            }
        } else {
            for (Player ps : Bukkit.getOnlinePlayers()) {
                ps.sendMessage(Config.FORMAT.getFormattedString().replace("%message%", e.getMessage()));
            }
        }
    }

}
