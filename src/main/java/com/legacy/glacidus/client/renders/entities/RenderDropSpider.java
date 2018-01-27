package com.legacy.glacidus.client.renders.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.glacidus.client.models.entity.ModelDropSpider;
import com.legacy.glacidus.client.renders.entities.layers.LayerDropSpiderEyes;
import com.legacy.glacidus.entities.hostile.EntityDropSpider;

@SideOnly(Side.CLIENT)
public class RenderDropSpider extends RenderLiving<EntityDropSpider>
{

    private static final ResourceLocation DROP_SPIDER_TEXTURE = new ResourceLocation("textures/entity/spider/spider.png");

    public RenderDropSpider(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelDropSpider(), 1.0F);

        this.addLayer(new LayerDropSpiderEyes(this));
    }

    @Override
    protected void preRenderCallback(EntityDropSpider entitylivingbaseIn, float partialTickTime)
    {
    	GlStateManager.scale(0.7F, 0.7F, 0.7F);
    }

    @Override
    protected float getDeathMaxRotation(EntityDropSpider entityLivingBaseIn)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDropSpider entity)
    {
        return DROP_SPIDER_TEXTURE;
    }

}