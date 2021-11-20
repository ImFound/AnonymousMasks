package dev.imfound.anonymousmasks.commands.subcommands;

import dev.imfound.anonymousmasks.commands.SubCommand;
import dev.imfound.anonymousmasks.config.Files;
import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadSubcmd extends SubCommand {

    // TODO METHOD FOR RELOAD

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission("anonymousmasks.commands.reload")) {
            if (args.length == 1) {
                new Files();
                sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.RELOADED.getFormattedString());
            } else {
                sendHelpMessage(sender);
            }
        }
    }

    private void sendHelpMessage(CommandSender sender) {
        if (sender instanceof Player) {
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
