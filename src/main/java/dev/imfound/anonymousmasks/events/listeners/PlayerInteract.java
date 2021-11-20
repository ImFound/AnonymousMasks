package dev.imfound.anonymousmasks.events.listeners;

import com.sun.tools.javac.jvm.Items;
import com.sun.tools.javac.util.ArrayUtils;
import dev.imfound.anonymousmasks.config.enums.Config;
import dev.imfound.anonymousmasks.config.enums.Lang;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import dev.imfound.anonymousmasks.utils.UpdateChecker;
import me.neznamy.tab.api.TABAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerInteract implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getHand() != EquipmentSlot.HAND) return;
            Player p = e.getPlayer();
            if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getItemMeta() != null && p.getInventory().getItemInMainHand().getType() != null) {
                if (MaskUtils.isMask(p.getInventory().getItemInMainHand())) {
                    if (p.getInventory().getHelmet() != null) {
                        p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.HEAD_ERROR.getFormattedString());
                        return;
                    }
                    p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
                    p.getInventory().getHelmet().setAmount(1);
                    p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    if (Config.METHOD.getString().equalsIgnoreCase("TAB")) {
                        NametagUtils.hideNametagTab(p);
                    } else {
                        NametagUtils.hideNametagNative(p);
                    }
                }
            }
        }
    }

}
