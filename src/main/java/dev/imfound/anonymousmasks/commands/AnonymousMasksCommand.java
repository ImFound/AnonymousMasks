package dev.imfound.anonymousmasks.commands;

import dev.imfound.anonymousmasks.AnonymousMasks;
import dev.imfound.anonymousmasks.commands.subcommands.GetSubcmd;
import dev.imfound.anonymousmasks.commands.subcommands.GiveSubcmd;
import dev.imfound.anonymousmasks.commands.subcommands.ReloadSubcmd;
import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

import static dev.imfound.anonymousmasks.utils.MaskUtils.giveMask;

public class AnonymousMasksCommand implements CommandExecutor {

    private final AnonymousMasks plugin;
    private final Map<String, SubCommand> commands;

    public AnonymousMasksCommand(final AnonymousMasks plugin) {
        this.commands = new HashMap<>();
        this.plugin = plugin;
        this.registerCommand("get", new GetSubcmd());
        this.registerCommand("give", new GiveSubcmd());
        this.registerCommand("reload", new ReloadSubcmd());
    }

    private void registerCommand(final String cmd, final SubCommand subCommand) {
        this.commands.put(cmd, subCommand);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("anonymousmasks")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.hasPermission("anonymousmasks.commands.help")) {
                        sendHelpMessage(sender);
                    } else {
                        p.sendMessage(Lang.PREFIX.getFormattedString() + Lang.NO_PERMS.getFormattedString());
                    }
                } else {
                    if(!this.commands.containsKey(args[0].toLowerCase())) {
                        sendHelpMessage(sender);
                        return true;
                    }
                    this.commands.get(args[0].toLowerCase()).onCommand(sender, args);
                }
            } else {
                if(args.length == 0) {
                    sendHelpMessage(sender);
                } else {
                    if(!this.commands.containsKey(args[0].toLowerCase())) {
                        sendHelpMessage(sender);
                        return true;
                    }
                    this.commands.get(args[0].toLowerCase()).onCommand(sender, args);
                }
            }
        }
        return false;
    }

    private void sendHelpMessage(CommandSender sender) {
        if(sender instanceof Player) {
            for (String s : Lang.HELP.getStringList()) {
                sender.sendMessage(Lang.getFormattedString(s));
            }
        } else {
            for (String s : Lang.HELP_CONSOLE.getStringList()) {
                sender.sendMessage(Lang.getFormattedString(s));
            }
        }
    }


}
