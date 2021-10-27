package com.quac.quactils.commands;

import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.TickDelay;
import jdk.nashorn.internal.ir.BlockStatement;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WormfinderCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "qtwormfinder";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "qtwormfinder";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ChatUtils.addMsg(Color.translate("&a[Quactils] Locating worms..."));
        List<BlockPos> lavaBlocks = new ArrayList<>();
        List<Chunk> chunks = new ArrayList<>();
        for(int i = 32; i < 52; i++) {
            chunks.add(new Chunk(Minecraft.getMinecraft().theWorld, i, i));
        }
        for(Chunk chunk : chunks) {
            for(BlockPos pos : chunk.getTileEntityMap().keySet()) {
                if(pos.getY() < 65) continue;
                Material mat = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock().getMaterial();
                if(mat.isLiquid()) {
                    if(mat.equals(Material.lava)) {
                        lavaBlocks.add(pos);
                    }
                }
            }
        }

        Runnable runnable1 = () -> {
            if (lavaBlocks.size() == 0) {
                ChatUtils.addMsg(Color.translate("&a[Quactils] Couldn't find any lava! Better luck next time!"));
            } else {
                ChatUtils.addMsg(Color.translate("&a[Quactils] Found &f" + lavaBlocks.size() + "&a lava Blocks! Getting the coordinates of 3 random ones."));
                Runnable runnable2 = () -> {
                    try {
                        int randomInt = new Random().nextInt(lavaBlocks.size()) - 1;
                        for(int i = 0; i < 3; i++) {
                            BlockPos blockPos = lavaBlocks.get(randomInt);
                            ChatUtils.addMsg(Color.translate("&a[Quactils] &f" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ()));
                        }
                    } catch (Exception e) {
                        ChatUtils.addMsg(Color.translate("&a[Quactils] Something went wrong!"));
                    }
                };
                new TickDelay(runnable2, 20);
            }
        };
        new TickDelay(runnable1, 20);
    }
}
