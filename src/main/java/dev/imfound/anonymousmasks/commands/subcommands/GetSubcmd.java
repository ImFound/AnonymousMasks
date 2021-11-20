package dev.imfound.anonymousmasks.commands.subcommands;

import dev.imfound.anonymousmasks.commands.SubCommand;
import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.imfound.anonymousmasks.utils.MaskUtils.giveMask;

public class GetSubcmd extends SubCommand {
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 1) {
                if(p.hasPermission("anonymousmasks.commands.get")) {
                    giveMask((Player) sender);
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GETTED.getFormattedString());
                } else {
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.NO_PERMS.getFormattedString());
                }
            } else {
                for(String s : Lang.HELP.getStringList()) {
                    p.sendMessage(Lang.getFormattedString(s));
                }
            }
        } else {
            plugin.getLogger().severe("Command executable only in-game");
        }
    }
}
