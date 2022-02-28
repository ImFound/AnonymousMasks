package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.config.enums.Settings;
import dev.imfound.anonymousmasks.config.enums.Lang;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

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
                } else if(Settings.METHOD.getString().equalsIgnoreCase("Native")) {
                    NametagUtils.hideNametagNative(p);
                } else if(Settings.METHOD.getString().equalsIgnoreCase("ArmorStand")){
                    NametagUtils.hideNametagArmorStand(p);
                }
            }
        }
    }


    @EventHandler
    public void onRightClick(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked() instanceof Player) {
            Player entity = (Player) e.getRightClicked();
            Player player = e.getPlayer();
            if(player.hasPermission("anonymousmasks.utils.name")) {
                if(entity.getInventory().getHelmet() != null && entity.getInventory().getHelmet().getItemMeta() != null && entity.getInventory().getHelmet().getItemMeta().getDisplayName() != null && entity.getInventory().getHelmet().getItemMeta().getDisplayName().equals(Settings.ITEM_DISPLAYNAME.getFormattedString())) {
                    player.sendMessage(Lang.PREFIX.getFormattedString() + Lang.RIGHT_CLICK.getFormattedString().replace("<player>", entity.getName()));
                }
            }
        }
    }
}
