package com.quac.quactils.Gui;

import com.quac.quactils.Gui.Screens.MainScreen;
import com.quac.quactils.Main;
import com.quac.quactils.config.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;
import sun.awt.image.PixelConverter;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.List;

public class GuiHandler {
    public List<Long> l_cps = new ArrayList<>();
    public List<Long> r_cps = new ArrayList<>();

    @SubscribeEvent
    public void test(RenderGameOverlayEvent.Post event) {
        Minecraft instance = Minecraft.getMinecraft();
        if(event.type == RenderGameOverlayEvent.ElementType.ALL) {
            int amountOfFeatures = 0;

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

            int bgWidth = 100;

            //Gui.drawRect(x-2, y-2, x + textWidth + 2, y + fontHeight + 1, new Color(0, 0, 0, 110).getRGB());
            int fontHeight = instance.fontRendererObj.FONT_HEIGHT;

            if(Config.fpsCounter) {
                amountOfFeatures++;

                String fpsText = "FPS: " + Minecraft.getDebugFPS();
                int x = 6;
                int y = 5;

                //int textWidth = instance.fontRendererObj.getStringWidth(fpsText);
                if(Config.featureBackgrounds)
                    Gui.drawRect(x-2, y-2, x + bgWidth, y + fontHeight, new Color(0, 0, 0, 110).getRGB());
                drawString(fpsText, x, y, Config.fpsCounterColor.getRGB());
            }

            if(Config.pingCounter) {
                amountOfFeatures++;
                String pingText = "Ping: " + ping;
                int x = 6;
                int y = 16;

                //int textWidth = instance.fontRendererObj.getStringWidth(pingText);
                if(Config.featureBackgrounds)
                    Gui.drawRect(x-2, y-2, x + bgWidth, y + fontHeight, new Color(0, 0, 0, 110).getRGB());
                drawString(pingText, x, y, Config.pingCounterColor.getRGB());
            }

            if(Config.cpsCounter) {
                amountOfFeatures++;
                String cpsText = "CPS: " + lcps + " | " + rcps;
                int x = 6;
                int y = 27;

                //int textWidth = instance.fontRendererObj.getStringWidth(cpsText);
                if(Config.featureBackgrounds)
                    Gui.drawRect(x-2, y-2, x + bgWidth, y + fontHeight, new Color(0, 0, 0, 110).getRGB());
                drawString(cpsText, x, y, Config.cpsCounterColor.getRGB());
            }

            if(Config.coordinates) {
                amountOfFeatures += 3;
                int xCoords = (int)v.xCoord;
                int yCoords = (int)v.yCoord;
                int zCoords = (int)v.zCoord;

                double pitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
                double yaw = MathHelper.wrapAngleTo180_float(Minecraft.getMinecraft().thePlayer.rotationYaw);

                pitch = Math.round(pitch * 100.0)/ 100.0;
                yaw = Math.round(yaw * 100.0)/ 100.0;

                int x = 6;
                int y = 38;

                String coordsText = "XYZ: " + xCoords + ", " + yCoords + ", " + zCoords;
                String pitchYawText = "PY: " + pitch + ", " + yaw;

                if(Config.compactCoordinates) {
                    if(Config.featureBackgrounds) {
                        if(!Config.pitchAndYaw) {
                            Gui.drawRect(x - 2, y - 2, x + bgWidth, y + fontHeight, new Color(0, 0, 0, 110).getRGB());
                        } else {
                            Gui.drawRect(x - 2, y - 2, x + bgWidth, y + fontHeight * 2 + 2, new Color(0, 0, 0, 110).getRGB());
                        }
                    }

                    drawString(coordsText, x, y, Config.coordinatesColor.getRGB());
                    if(Config.pitchAndYaw) {
                        drawString(pitchYawText, x, y + 11, Config.coordinatesColor.getRGB());
                    }
                } else {
                    if(Config.featureBackgrounds) {
                        if(Config.pitchAndYaw) {
                            Gui.drawRect(x-2, y-2, x + bgWidth, y + fontHeight * 4 + 6, new Color(0, 0, 0, 110).getRGB());
                        } else {
                            Gui.drawRect(x-2, y-2, x + bgWidth, y + fontHeight * 3 + 4, new Color(0, 0, 0, 110).getRGB());
                        }
                    }

                    drawString("X: " + xCoords, x, y, Config.coordinatesColor.getRGB());
                    drawString("Y: " + yCoords, x, y + 11, Config.coordinatesColor.getRGB());
                    drawString("Z: " + zCoords, x, y + 22, Config.coordinatesColor.getRGB());

                    if(Config.pitchAndYaw) {
                        drawString(pitchYawText, x, y + 33, Config.coordinatesColor.getRGB());
                    }
                }
            }

            if(Config.lookInfo) {
                MovingObjectPosition.MovingObjectType type = instance.objectMouseOver.typeOfHit;
                String name = "NOT FOUND";
                String typeName = "NOT FOUND";
                if(type == MovingObjectPosition.MovingObjectType.BLOCK) {
                    BlockPos bp = instance.objectMouseOver.getBlockPos();
                    IBlockState bs = Minecraft.getMinecraft().theWorld.getBlockState(bp);
                    Block b = bs.getBlock();
                    name = I18n.format(b.getLocalizedName());
                    typeName = "Block";
                } else if(type == MovingObjectPosition.MovingObjectType.ENTITY) {
                    Entity e = instance.objectMouseOver.entityHit;
                    name = e.getDisplayName().getFormattedText();
                    typeName = "Entity";
                } else { return; }
                ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
                int centerX = res.getScaledWidth() / 2;
                String s1 = "Looking at: " + name;
                String s2 = "Type: " + typeName;
                drawString(s1, 5, 67, Config.lookInfoColor.getRGB());
                drawString(s2, 5, 77, Config.lookInfoColor.getRGB());
            }
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
    public void onKey(InputEvent.KeyInputEvent event) {
        if(Keyboard.isKeyDown(Main.configKey.getKeyCode())) {
            Main.setGui(Main.config.gui());
        } else if(Keyboard.isKeyDown(Main.mainMenuKey.getKeyCode())) {
            Main.setGui(new MainScreen());
        }
    }



    public void drawString(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color);
    }
}
