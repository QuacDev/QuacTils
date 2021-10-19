package com.quac.quactils.Overlays;

import com.quac.quactils.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;

public class EndermanOverlay extends RenderLiving<EntityEnderman> {
    protected ResourceLocation newTexture = new ResourceLocation(Main.MODID, "dreem.png");

    public EndermanOverlay(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
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
