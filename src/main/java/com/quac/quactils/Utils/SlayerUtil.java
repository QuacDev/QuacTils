package com.quac.quactils.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class SlayerUtil {
    public static boolean isRevTier5() {
        List<String> l = ScoreboardUtil.getSidebarLines();
        if(l.contains(Color.translate("&5Revenant Horror V"))) {
            return l.contains(Color.translate("&eSlay the boss!"));
        }
        return false;
    }

    public static boolean getRevTier5Block(Block block) {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(Block.getBlockById(159));
        blocks.add(Block.getBlockById(155));
        blocks.add(Block.getBlockById(44));
        blocks.add(Block.getBlockById(156));
        blocks.add(Block.getBlockById(163));
        blocks.add(Block.getBlockById(5));

        return blocks.contains(block);
    }
}
