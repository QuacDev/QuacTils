package com.quac.quactils;

import com.quac.quactils.Gui.GuiHandler;
import com.quac.quactils.EventHandlers.TestEvents;
import com.quac.quactils.Utils.C;
import com.quac.quactils.commands.ConfigCommand;
import com.quac.quactils.config.Config;
import gg.essential.vigilance.Vigilance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.File;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "QuacTils";
    public static final String VERSION = "1.0.3";
    public static Config config;
    private static GuiScreen guiToOpen;

    public static void setGui(GuiScreen gui) {
        guiToOpen = gui;
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Vigilance.initialize();
        config = new Config(new File("./config/config.toml"));
        config.preload();

		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        ClientCommandHandler.instance.registerCommand(new ConfigCommand());

        MinecraftForge.EVENT_BUS.register(new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new TestEvents());
        MinecraftForge.EVENT_BUS.register(new Main());
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (guiToOpen != null) {
            try {
                System.out.println("Opening GUI...");
                Minecraft.getMinecraft().displayGuiScreen(guiToOpen);
            } catch (Exception e) {
                e.printStackTrace();
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(C.C("&cError while opening GUI. Check log for more details")));
            }
            guiToOpen = null;
        }
    }
}
