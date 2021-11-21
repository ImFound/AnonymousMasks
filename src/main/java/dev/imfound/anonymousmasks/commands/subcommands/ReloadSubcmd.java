package dev.imfound.anonymousmasks.commands.subcommands;

import dev.imfound.anonymousmasks.commands.SubCommand;
import dev.imfound.anonymousmasks.config.Files;
import dev.imfound.anonymousmasks.config.enums.Lang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadSubcmd extends SubCommand {

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission("anonymousmasks.commands.reload")) {
            Files.reload("lang", Files.LANG);
            Files.reload("settings", Files.SETTINGS);
            sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.RELOADED.getFormattedString());
        } else {
            sender.sendMessage(Lang.PREFIX.getFormattedString() + Lang.NO_PERMS.getFormattedString());
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
