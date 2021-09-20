package com.quac.sbmod.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements ICommand {

    @Override
    public String getCommandName() {
        return "testcommand";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "Idfk.";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> list =  new ArrayList<>();
        list.add("tc");
        list.add("anotheralias");
        return list;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if( sender instanceof EntityPlayer ) {
            EntityPlayer p = (EntityPlayer) sender;
            p.addChatMessage(new ChatComponentText("Test Command worked"));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
