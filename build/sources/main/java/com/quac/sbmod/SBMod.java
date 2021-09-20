package com.quac.sbmod;

import com.quac.sbmod.Gui.GuiHandler;
import com.quac.sbmod.EventHandlers.TestEvents;
import com.quac.sbmod.commands.TestCommand;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SBMod.MODID, version = SBMod.VERSION)
public class SBMod
{
    public static final String MODID = "quacsbmod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        ClientCommandHandler.instance.registerCommand(new TestCommand());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new TestEvents());
    }
}
