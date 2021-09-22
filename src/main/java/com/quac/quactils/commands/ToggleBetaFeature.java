package com.quac.quactils.commands;

import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.config.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class ToggleBetaFeature extends CommandBase {

    @Override
    public String getCommandName() {
        return "togglebetafeature";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "togglebetafeature";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("tbf");
        return aliases;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if(args.length == 0) {
            ChatUtils.addMsg(Color.translate("&cFeature Not Found! Please choose from the list that u can find with '/tbf help'."));
            return;
        }
        switch (args[0]) {
            case "lookinfo":
                Config.lookInfo = !Config.lookInfo;
                ChatUtils.addMsg(Color.translate(ChatUtils.getBooleanMessage("&fBeta feature 'lookinfo' is now: " + Config.lookInfo)));
                break;
            case "help":
                ChatUtils.addMsg(Color.translate("&aBeta Features: 'lookinfo'"));
                break;
            default:
            case "":
                ChatUtils.addMsg(Color.translate("&cFeature Not Found! Please choose from the list that u can find with '/tbf help'."));
                break;
        }
    }
}
