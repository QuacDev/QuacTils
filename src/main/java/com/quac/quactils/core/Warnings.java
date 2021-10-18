package com.quac.quactils.core;

import com.quac.quactils.Utils.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;

public class Warnings {
    public static void playWormWarning() {
        playDing();
        displayTitle(Color.translate("&cWORM!!!"), 2);
    }

    public static void playGlacitePieceWarning(String piece) {
        playDing();
        displayTitle(Color.translate("&cGLACITE " + piece.toUpperCase() + "!!!"), 2);
    }

    public static void playEnderPieceWarning(String piece) {
        playDing();
        displayTitle(Color.translate("&cENDER " + piece.toUpperCase() + "!!!"), 2);
    }

    public static void playSpecialZealotWarning() {
        playDing();
        displayTitle(Color.translate("&cSPECIAL ZEALOT!!!"), 1.5);
    }

    public static void playDing() {
        EntityPlayer p = Minecraft.getMinecraft().thePlayer;
        p.playSound("random.orb", 25f, 0.1f);
    }

    public static void displayTitle(String s, double seconds) {
        GuiIngame gig = Minecraft.getMinecraft().ingameGUI;
        gig.displayTitle(null, null, 1, (int) (seconds * 20), 1);
        gig.displayTitle(s, "", 0, 0, 0);
    }
}
