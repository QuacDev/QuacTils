package com.quac.quactils;

import com.quac.quactils.Gui.GuiHandler;
import com.quac.quactils.EventHandlers.PlayerEvents;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.commands.FakeMSGCommand;
import com.quac.quactils.commands.MainCommand;
import com.quac.quactils.commands.PlayWarningCommand;
import com.quac.quactils.commands.ToggleBetaFeature;
import com.quac.quactils.config.Config;
import gg.essential.vigilance.Vigilance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "QuacTils";
    public static final String VERSION = "1.0.6.2";
    public static Config config;
    private static GuiScreen guiToOpen;

    public static KeyBinding mainMenuKey = new KeyBinding("Open Main Menu", Keyboard.KEY_NONE, "QuacTils");
    public static KeyBinding configKey = new KeyBinding("Open Config", Keyboard.KEY_NONE, "QuacTils");

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
        ClientCommandHandler.instance.registerCommand(new MainCommand());
        ClientCommandHandler.instance.registerCommand(new ToggleBetaFeature());
        ClientCommandHandler.instance.registerCommand(new PlayWarningCommand());
        ClientCommandHandler.instance.registerCommand(new FakeMSGCommand());

        MinecraftForge.EVENT_BUS.register(new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new Main());

        ClientRegistry.registerKeyBinding(configKey);
        ClientRegistry.registerKeyBinding(mainMenuKey);

        String hypixelAPIKey = Config.apiKey;

    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (guiToOpen != null) {
            try {
                System.out.println("Opening GUI...");
                Minecraft.getMinecraft().displayGuiScreen(guiToOpen);
            } catch (Exception e) {
                e.printStackTrace();
                ChatUtils.addMsg("&cError while opening GUI. Check log for more details");
            }
            guiToOpen = null;
        }
    }
}
