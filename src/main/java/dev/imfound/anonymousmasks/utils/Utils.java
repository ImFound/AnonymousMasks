package dev.imfound.anonymousmasks.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Player> getMaskedPlayers() {
        List<Player> pList = new ArrayList<>();
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(MaskUtils.isMask(p.getInventory().getHelmet())) pList.add(p);
        }
        return pList;
    }

}
