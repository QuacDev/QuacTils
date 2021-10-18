package com.quac.quactils.commands;

import com.quac.quactils.Gui.Screens.MainScreen;
import com.quac.quactils.Main;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.TickDelay;
import com.quac.quactils.core.Warnings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class PlayWarningCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "playwarning";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "playwarning";
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
        if(args.length != 1) {
            ChatUtils.addMsg(Color.translate("&cWarning not found! Please use '/playwarning list' for a list of the warnings"));
        } else {
            switch (args[0].toLowerCase()) {
                case "worm": Warnings.playWormWarning(); break;
                case "ender_piece": Warnings.playEnderPieceWarning("piece"); break;
                case "glacite_piece": Warnings.playGlacitePieceWarning("piece"); break;
                case "special_zealot": Warnings.playSpecialZealotWarning(); break;
                case "list":
                    ChatUtils.addMsg(Color.translate("&aCurrent warnings: 'worm', 'ender_piece', 'glacite_piece', 'special_zealot'"));
                    break;
                default:
                case "":
                    ChatUtils.addMsg(Color.translate("&cWarning not found! Please use '/playwarning list' for a list of the warnings"));
                    break;
            }
        }
    }
}
