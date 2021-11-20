package dev.imfound.anonymousmasks.commands.subcommands;

import dev.imfound.anonymousmasks.commands.SubCommand;
import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.imfound.anonymousmasks.utils.MaskUtils.giveMask;

public class GiveSubcmd extends SubCommand {
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 2) {
                if (p.hasPermission("anonymousmasks.commands.give")) {
                    if (Bukkit.getPlayer(args[1]) == null) {
                        p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_NOT_ONLINE.getFormattedString().replace("<player>", args[1]));
                        return;
                    }
                    Player toGive = Bukkit.getPlayer(args[1]);
                    giveMask(toGive);
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GIVED.getFormattedString().replace("<player>", args[1]));
                } else {
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.NO_PERMS.getFormattedString());
                }
            } else {
                for (String s : Lang.HELP.getStringList()) {
                    p.sendMessage(Lang.getFormattedString(s));
                }
            }
        } else {
            if (args.length == 2) {
                if (Bukkit.getPlayer(args[1]) == null) {
                    sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_NOT_ONLINE.getFormattedString().replace("<player>", args[1]));
                    return;
                }
                Player toGive = Bukkit.getPlayer(args[1]);
                giveMask(toGive);
                sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GIVED.getFormattedString().replace("<player>", args[1]));
            } else {
                for (String s : Lang.HELP.getStringList()) {
                    sender.sendMessage(Lang.getFormattedString(s));
                }
            }
        }
    }
}
