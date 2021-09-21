package com.quac.quactils.commands;

import com.quac.quactils.Main;
import com.quac.quactils.Utils.TickDelay;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ConfigCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "config";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "config";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Runnable runnable = () -> Main.setGui(Main.config.gui());
        new TickDelay(runnable, 1);
    }
}
