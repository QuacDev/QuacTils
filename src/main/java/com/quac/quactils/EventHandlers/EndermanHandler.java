package com.quac.quactils.EventHandlers;

import com.quac.quactils.Main;
import com.quac.quactils.config.Config;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EndermanHandler {
   @SubscribeEvent
    public void onSound(PlaySoundEvent e) {
        if (Config.endermenPerson) {
            if (e.name.startsWith("mob.endermen")) {
                System.out.println(e.name);
                float xPos = e.sound.getXPosF();
                float yPos = e.sound.getYPosF();
                float zPos = e.sound.getZPosF();
                if (e.name.endsWith(".portal")) {
                    e.result = getSound("mob.dream.teleport", xPos, yPos, zPos);
                } else if (e.name.endsWith(".scream")) {
                    e.result = getSound("mob.dream.sayloud", xPos, yPos, zPos);
                } else if (e.name.endsWith(".hit")) {
                    e.result = getSound("mob.dream.hit", xPos, yPos, zPos);
                } else if (e.name.endsWith(".death")) {
                    e.result = getSound("mob.dream.die", xPos, yPos, zPos);
                } else if (e.name.endsWith(".idle")) {
                    e.result = getSound("mob.dream.mask", xPos, yPos, zPos);
                } else {
                    e.result = null;
                }
            }
        }
    }

    public ISound getSound(String path, float x, float y, float z) {
        return PositionedSoundRecord.create(new ResourceLocation(Main.MODID, path), x, y, z);
    }

    public ISound getSound(String path, float pitch) {
        return PositionedSoundRecord.create(new ResourceLocation(Main.MODID, path), pitch);
    }
}
