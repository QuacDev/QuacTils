package com.quac.sbmod.Gui;

import com.quac.sbmod.Utils.C;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

            drawString(C.C("&3FPS: " + Minecraft.getDebugFPS()), 3, 3, 1);
            drawString(C.C("&3Ping: " + ping), 3, 13, 1);
            drawString(C.C("&3CPS: " + lcps + " | " + rcps), 3, 23, 1);
            drawString(C.C("&3XYZ: " + coords), 3, 33, 1);
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

    public void drawString(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color);
    }
}
