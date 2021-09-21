package com.quac.quactils.Gui;

import com.quac.quactils.Main;
import com.quac.quactils.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class GuiHandler {
    public List<Long> l_cps = new ArrayList<>();
    public List<Long> r_cps = new ArrayList<>();

    @SubscribeEvent
    public void test(RenderGameOverlayEvent.Post event) {
        if(event.type == RenderGameOverlayEvent.ElementType.ALL) {
            String ping = "Not Found!";
            if (Minecraft.getMinecraft().getNetHandler() != null) {
                if (Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()) != null) {
                    ping = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime() + "ms";
                }
            }

            l_cps.removeIf(timestamp -> System.currentTimeMillis() - timestamp >= 1000);
            r_cps.removeIf(timestamp -> System.currentTimeMillis() - timestamp >= 1000);

            String lcps = "0";
            if (l_cps.size() > 0) {
                lcps = "" + l_cps.size();
            }

            String rcps = "0";
            if (r_cps.size() > 0) {
                rcps = "" + r_cps.size();
            }

            Vec3 v = Minecraft.getMinecraft().thePlayer.getPositionVector();
            String coords = "" + (int)v.xCoord + ", " + (int)v.yCoord + ", " + (int)v.zCoord;

            if(Config.fpsCounter) drawString("FPS: " + Minecraft.getDebugFPS(), 3, 3, Config.fpsCounterColor.getRGB());
            if(Config.pingCounter) drawString("Ping: " + ping, 3, 13, Config.pingCounterColor.getRGB());
            if(Config.cpsCounter) drawString("CPS: " + lcps + " | " + rcps, 3, 23, Config.cpsCounterColor.getRGB());
            if(Config.coordinates) drawString("XYZ: " + coords, 3, 33, Config.coordinatesColor.getRGB());
        }
    }

    @SubscribeEvent
    public void onClick(MouseEvent event) {
        if(event.buttonstate && event.button == 0) {
            l_cps.add(System.currentTimeMillis());
        }

        if(event.buttonstate && event.button == 1) {
            r_cps.add(System.currentTimeMillis());
        }
    }

    @SubscribeEvent
    public void onKey(GuiScreenEvent.KeyboardInputEvent event) {
        if(Keyboard.isKeyDown(Keyboard.KEY_J)) {
            Main.setGui(Main.config.gui());
        }
    }

    public void drawString(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color);
    }
}
