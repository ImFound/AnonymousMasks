package dev.imfound.anonymousmasks.events.listeners;

import dev.imfound.anonymousmasks.AnonymousMasks;
import dev.imfound.anonymousmasks.config.enums.Settings;
import dev.imfound.anonymousmasks.utils.MaskUtils;
import dev.imfound.anonymousmasks.utils.NametagUtils;
import dev.imfound.anonymousmasks.utils.UpdateChecker;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoin implements Listener {

    private JavaPlugin plugin;

    public PlayerJoin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(MaskUtils.isMask(p.getInventory().getHelmet())) {
            Bukkit.getScheduler().runTaskLater(AnonymousMasks.getInstance(), () -> {
                if(Settings.METHOD.getString().equalsIgnoreCase("TAB")) {
                    NametagUtils.hideNametagTab(p);
                } else if(Settings.METHOD.getString().equalsIgnoreCase("Native")) {
                    NametagUtils.hideNametagNative(p);
                } else if(Settings.METHOD.getString().equalsIgnoreCase("ArmorStand")){
                    NametagUtils.hideNametagArmorStand(p);
                }
            }, 3L);
        }
        if(p.hasPermission("anonymousmasks.update")) {
            new UpdateChecker(plugin, 89836).getVersion(version -> {
                if (!plugin.getDescription().getVersion().equals(version)) {
                    TextComponent component = new TextComponent("§c§lANONYMOUS§f§lMASKS §8» §aUpdate available!");
                    component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8» §fClick here to open §eSpigotMC§f page!").create()));
                    component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/anonymousmask.89836/"));
                    p.spigot().sendMessage(component);
                }
            });
        }
    }

}
