package com.quac.quactils.commands;

import com.quac.quactils.Gui.Screens.MainScreen;
import com.quac.quactils.Main;
import com.quac.quactils.Utils.TickDelay;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class MainCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "quactils";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "quactils";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("qt");
        return aliases;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Runnable runnable = () -> Main.setGui(new MainScreen());
        new TickDelay(runnable, 1);
    }
}
