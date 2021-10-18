package com.quac.quactils.EventHandlers;

import com.quac.quactils.Gui.Screens.MainScreen;
import com.quac.quactils.Main;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.TickDelay;
import com.quac.quactils.config.Config;
import com.quac.quactils.core.Warnings;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.Date;

public class PlayerEvents {
    @SubscribeEvent
    public void onMessageRecieve(ClientChatReceivedEvent e) {
        if(cfm(Color.translate("You hear the sound of something approaching..."), e) && Config.skyblockWormWarning) {Warnings.playWormWarning();}
        if(Config.skyblockEnderArmorWarning) {
            if(cfm(Color.translate("RARE DROP! Ender Helmet"), e)) {Warnings.playEnderPieceWarning("Helmet");}
            if(cfm(Color.translate("RARE DROP! Ender Chestplate"), e)) {Warnings.playEnderPieceWarning("Chestplate");}
            if(cfm(Color.translate("RARE DROP! Ender Leggings"), e)) {Warnings.playEnderPieceWarning("Leggings");}
            if(cfm(Color.translate("RARE DROP! Ender Boots"), e)) {Warnings.playEnderPieceWarning("Boots");}
        }
        if(Config.skyblockGlaciteArmorWarning) {
            if(cfm(Color.translate("RARE DROP! Glacite Helmet"), e)) {Warnings.playGlacitePieceWarning("Helmet");}
            if(cfm(Color.translate("RARE DROP! Glacite Chestplate"), e)) {Warnings.playGlacitePieceWarning("Chestplate");}
            if(cfm(Color.translate("RARE DROP! Glacite Leggings"), e)) {Warnings.playGlacitePieceWarning("Leggings");}
            if(cfm(Color.translate("RARE DROP! Glacite Boots"), e)) {Warnings.playGlacitePieceWarning("Boots");}
        }
        if(cfm(Color.translate("A special &5Zealot has spawned nearby!"), e) && Config.skyblockSpecialZealotWarning) {Warnings.playSpecialZealotWarning();}
    }

    boolean canCheckTime = true;

    @SubscribeEvent
    public void onLobbyChange(EntityJoinWorldEvent e) {
        if(Config.skyblockLobbyDay) {
            if(e.entity.equals(Minecraft.getMinecraft().thePlayer)) {
                if(canCheckTime) {
                    canCheckTime = false;
                    Runnable runnable = () -> {
                        float ticks = Minecraft.getMinecraft().theWorld.getWorldTime() / 24000;
                        ChatUtils.addMsg(Color.translate("&aLobby day: &e" + ticks));
                        Runnable runnable2 = () -> canCheckTime = true;
                        new TickDelay(runnable2, 20);
                    };
                    new TickDelay(runnable, 5);
                }
            }
        }
    }

    public boolean cfm(String s, ClientChatReceivedEvent e) {
        //System.out.println("Getting: " + e.message.getUnformattedText());
        return e.message.getUnformattedText().contains(s);
    }
}
