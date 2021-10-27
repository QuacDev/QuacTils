package com.quac.quactils.Overlays;

import com.quac.quactils.Main;
import com.quac.quactils.Utils.ImageUtils;
import com.quac.quactils.config.Config;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class EndermanOverlay extends RenderLiving<EntityEnderman> {
    protected ResourceLocation newTexture = ImageUtils.imageToResourceLocation(ImageUtils.getImageFromLink("https://mc-heads.net/skin/" + Config.endermenPersonName));

    public EndermanOverlay(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) throws IOException {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    protected void preRenderCallback(EntityEnderman entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEnderman entity) {
        return this.newTexture;
    }
}
