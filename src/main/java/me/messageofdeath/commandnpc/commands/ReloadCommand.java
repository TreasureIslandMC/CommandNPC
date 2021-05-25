package me.messageofdeath.commandnpc.commands;

import net.citizensnpcs.api.util.Messaging;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.messageofdeath.commandnpc.CommandNPC;
import me.messageofdeath.commandnpc.database.settings.language.LanguageSettings;
import me.messageofdeath.commandnpc.database.settings.plugin.PluginSettings;
import me.messageofdeath.commandnpc.utilities.bungeecord.BungeeCordUtil;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (args.length != 1) {
            Messaging.sendError(sender, LanguageSettings.Commands_WrongArgs.getSetting());
            return false;
        }

        if (!args[0].equalsIgnoreCase("reload")) {
            Messaging.sendError(sender, LanguageSettings.Commands_WrongArgs.getSetting());
            return false;
        }

        if (!sender.hasPermission("commandnpc.admin") && !sender.isOp()) {
            Messaging.sendError(sender, LanguageSettings.Commands_NoPermission.getSetting());
            return false;
        }

        if (PluginSettings.BungeeCord.getBoolean()) {
            BungeeCordUtil.disableUtil();
        }

        CommandNPC.getInstance().reloadConfigX();
        Messaging.send(sender, LanguageSettings.Commands_CmdNPC_Reload.getSetting());
        if (PluginSettings.BungeeCord.getBoolean()) {
            BungeeCordUtil.setupUtil();
        }
        return true;
    }
}
