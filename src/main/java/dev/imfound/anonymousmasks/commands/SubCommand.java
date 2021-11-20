package dev.imfound.anonymousmasks.commands;

import dev.imfound.anonymousmasks.AnonymousMasks;
import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    protected final AnonymousMasks plugin;

    public SubCommand() {
        this.plugin = AnonymousMasks.getInstance();
    }

    public abstract void onCommand(CommandSender sender, final String[] args);

}
