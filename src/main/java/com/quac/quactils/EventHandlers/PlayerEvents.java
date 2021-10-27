package com.quac.quactils.EventHandlers;

import com.google.gson.JsonObject;
import com.quac.quactils.Main;
import com.quac.quactils.Utils.ApiUtils;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.TickDelay;
import com.quac.quactils.config.Config;
import com.quac.quactils.core.Warnings;
import gg.essential.api.utils.WebUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tv.twitch.chat.Chat;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.MalformedURLException;

public class PlayerEvents {
    @SubscribeEvent
    public void onMessageRecieve(ClientChatReceivedEvent e) throws MalformedURLException {
        String msg = e.message.getUnformattedText();
        if(isFromPlayer(msg)) return;

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Friend/Guild join leave hider
        if(cfm(Color.translate("left."), e) || cfm(Color.translate("joined."), e)) {
            if(cfm(Color.translate("Friend >"), e)) {
                e.setCanceled(Config.qolFriendJoinLeaveHider);
            }
            if(cfm(Color.translate("Guild >"), e)) {
                e.setCanceled(Config.qolGuildJoinLeaveHider);
            }
        }
        // Tip hiders
        if(cfm(Color.translate("You were tipped by"), e)) {
            if(cfm(Color.translate("in the last minute!"), e)) {
                e.setCanceled(Config.qolTipHider);
            }
        }
        if(cfm(Color.translate("You tipped"), e)) {
            e.setCanceled(Config.qolTipHider);
        }
        // Guild exp hider
        if(cfm(Color.translate("You earned"), e)) {
            if(cfm(Color.translate("GEXP"), e)) {
                e.setCanceled(Config.qolGuildExpHider);
            }
        }
        // RNG drop copier
        if(Config.skyblockAutoCopyRng) {
            if(cfm(Color.translate("CRAZY RARE DROP!"), e)) {
                ChatUtils.addMsg(Color.translate(ChatUtils.prefix + "automatically copied rng drop message to clipboard"));
                clipboard.setContents(new StringSelection(msg), null);
            }
            if(cfm(Color.translate("INSANE DROP!"), e)) {
                ChatUtils.addMsg(Color.translate(ChatUtils.prefix + "automatically copied rng drop message to clipboard"));
                clipboard.setContents(new StringSelection(msg), null);
            }
        }


        // API GRABBER
        if(cfm(Color.translate("Your new API key is"), e)) {
            String apiKey = msg.substring(20);
            System.out.println(Color.translate(ChatUtils.prefix + "found api key! '" + apiKey + "'"));
            Config.apiKey = apiKey;
            ChatUtils.addMsg(ChatUtils.prefix + "found api key! '" + apiKey + "'");
        }

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

        JsonObject api = Main.apiJson;
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

    public boolean isFromPlayer(String s) {
        return s.contains(":");
    }

    public boolean cfm(String s, ClientChatReceivedEvent e) {
        //System.out.println("Getting: " + e.message.getUnformattedText());
        return e.message.getUnformattedText().contains(s);
    }
}
