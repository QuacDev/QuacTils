package com.quac.sbmod;

import com.quac.sbmod.Gui.GuiHandler;
import com.quac.sbmod.EventHandlers.TestEvents;
import com.quac.sbmod.Utils.C;
import com.quac.sbmod.Utils.TickDelay;
import com.quac.sbmod.commands.ConfigCommand;
import com.quac.sbmod.commands.TestCommand;
import com.quac.sbmod.config.Config;
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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.File;
import java.util.Arrays;

@Mod(modid = SBMod.MODID, version = SBMod.VERSION)
public class SBMod
{
    public static final String MODID = "quacsbmod";
    public static final String VERSION = "1.0";
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
        ClientCommandHandler.instance.registerCommand(new TestCommand());
        ClientCommandHandler.instance.registerCommand(new ConfigCommand());

        MinecraftForge.EVENT_BUS.register(new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new TestEvents());
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
