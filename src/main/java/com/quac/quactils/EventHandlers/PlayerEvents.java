package com.quac.quactils.EventHandlers;

import com.quac.quactils.Utils.ChatUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvents {
    @SubscribeEvent
    public void onDealHit(PlayerInteractEvent e) {
        /*if(e.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            BlockPos bp = e.pos;
            IBlockState bs = Minecraft.getMinecraft().theWorld.getBlockState(bp);
            Block b = bs.getBlock();
            ChatUtils.addMsg("&aHit Block: &f" + I18n.format(b.getLocalizedName()));
        }*/
    }
}
