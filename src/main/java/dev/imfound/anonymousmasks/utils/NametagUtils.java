package dev.imfound.anonymousmasks.utils;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.team.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NametagUtils {


    public static void hideNametagArmorStand(Player p) {
        for(Entity e : p.getPassengers()) {
            if(e instanceof ArmorStand) {
                p.removePassenger(e);
                e.remove();
            }
        }
        ArmorStand armorStand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        armorStand.setMarker(true);
        armorStand.setCustomName("mask");
        armorStand.setVisible(false);
        p.addPassenger(armorStand);
    }

    public static void showNametagArmorStand(Player p) {
        for(Entity e : p.getPassengers()) {
            if(e.getType() == EntityType.ARMOR_STAND && e.getCustomName().equals("mask")) {
                p.removePassenger(e);
                e.remove();
            }
        }
    }

    public static void hideNametagNative(Player p) {
        /*Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Team team = scoreboard.registerNewTeam("hide_nametag");
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        team.addEntry(p.getName());
        p.
        for (Player player : Bukkit.getOnlinePlayers()) {
            team.addEntry(player.getName());
        }
        p.setScoreboard(scoreboard);*/
        if(Bukkit.getScoreboardManager().getMainScoreboard().getTeam(p.getName()) != null) {
            Bukkit.getScoreboardManager().getMainScoreboard().getTeam(p.getName()).unregister();
        }
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(p.getName());
        team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        team.addEntry(p.getName());
    }

    public static void hideNametagTab(Player p) {
        TeamManager teamManager = TabAPI.getInstance().getTeamManager();
        teamManager.hideNametag(TabAPI.getInstance().getPlayer(p.getUniqueId()));
    }

    public static void showNametagNative(Player p) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(p.getName());
        assert team != null;
        team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        team.removeEntry(p.getName());
        team.unregister();
    }

    public static void showNametagTab(Player p) {
        TeamManager teamManager = TabAPI.getInstance().getTeamManager();
        teamManager.showNametag(TabAPI.getInstance().getPlayer(p.getUniqueId()));
    }

}
