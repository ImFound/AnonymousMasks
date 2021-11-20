package dev.imfound.anonymousmasks.utils;

import me.neznamy.tab.api.TABAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NametagUtils {

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
        TabPlayer tabPlayer = TABAPI.getPlayer(p.getUniqueId());
        tabPlayer.hideNametag();
    }

    public static void showNametagNative(Player p) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(p.getName());
        assert team != null;
        team.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        team.removeEntry(p.getName());
        team.unregister();
    }

    public static void showNametagTab(Player p) {
        TabPlayer tabPlayer = TABAPI.getPlayer(p.getUniqueId());
        tabPlayer.showNametag();
    }

}
