package com.quac.quactils.commands;

import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.core.Warnings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class FakeMSGCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "fakemsg";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "fakemsg";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();;
        return aliases;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        StringBuilder builder = new StringBuilder();
        for(String s : args) {
            builder.append(s + " ");
        }
        ChatUtils.addMsg(Color.translate(builder.toString()));
    }
}
