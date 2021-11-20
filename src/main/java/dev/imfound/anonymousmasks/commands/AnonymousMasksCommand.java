package dev.imfound.anonymousmasks.commands;

import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.imfound.anonymousmasks.utils.MaskUtils.giveMask;

public class AnonymousMasksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("anonymousmasks")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("anonymousmasks.commands.help")) {
                    if(args.length == 0) {
                        for(String s : Lang.HELP.getStringList()) {
                            p.sendMessage(Lang.getFormattedString(s));
                        }
                    } else {
                        if(args[0].equalsIgnoreCase("get")) {
                            if(args.length == 1) {
                                giveMask(p);
                                p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GETTED.getFormattedString());
                            } else {
                                for(String s : Lang.HELP.getStringList()) {
                                    p.sendMessage(Lang.getFormattedString(s));
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("give")) {
                            if(args.length == 2) {
                                if(Bukkit.getPlayer(args[1]) == null) {
                                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_NOT_ONLINE.getFormattedString().replace("<player>", args[1]));
                                    return true;
                                }
                                Player toGive = Bukkit.getPlayer(args[1]);
                                giveMask(toGive);
                                p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GIVED.getFormattedString().replace("<player>", args[1]));
                            } else {
                                for(String s : Lang.HELP.getStringList()) {
                                    p.sendMessage(Lang.getFormattedString(s));
                                }
                            }
                        } else {
                            for(String s : Lang.HELP.getStringList()) {
                                p.sendMessage(Lang.getFormattedString(s));
                            }
                        }
                    }
                } else {
                    p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.NO_PERMS.getFormattedString());
                }
            } else {
                if(args.length == 0) {
                    for(String s : Lang.HELP_CONSOLE.getStringList()) {
                        sender.sendMessage(Lang.getFormattedString(s));
                    }
                } else {
                    if(args[0].equalsIgnoreCase("give")) {
                        if(args.length == 2) {
                            if(Bukkit.getPlayer(args[1]) == null) {
                                sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_NOT_ONLINE.getFormattedString().replace("<player>", args[1]));
                                return true;
                            }
                            Player toGive = Bukkit.getPlayer(args[1]);
                            giveMask(toGive);
                            sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.MASK_GIVED.getFormattedString().replace("<player>", args[1]));
                        } else {
                            for(String s : Lang.HELP.getStringList()) {
                                sender.sendMessage(Lang.getFormattedString(s));
                            }
                        }
                    } else {
                        for(String s : Lang.HELP_CONSOLE.getStringList()) {
                            sender.sendMessage(Lang.getFormattedString(s));
                        }
                    }
                }
            }
        }
        return false;
    }


}
