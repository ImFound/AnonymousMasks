package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.config.enums.Settings;
import dev.imfound.anonymousmasks.config.enums.Lang;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteract implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getHand() != EquipmentSlot.HAND) return;
            Player p = e.getPlayer();
            if (MaskUtils.isMask(p.getInventory().getItemInMainHand())) {
                if (p.getInventory().getHelmet() != null) {
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.HEAD_ERROR.getFormattedString());
                    return;
                }
                p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
                p.getInventory().getHelmet().setAmount(1);
                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                if (Settings.METHOD.getString().equalsIgnoreCase("TAB")) {
                    NametagUtils.hideNametagTab(p);
                } else {
                    NametagUtils.hideNametagNative(p);
                }
            }
        }
    }

}
