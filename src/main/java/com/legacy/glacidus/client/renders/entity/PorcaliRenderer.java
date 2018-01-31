package com.legacy.glacidus.client.renders.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import com.legacy.glacidus.client.models.entity.ModelPorcali;
import com.legacy.glacidus.client.renders.entity.layers.porcali.PorcaliGlow;
import com.legacy.glacidus.client.renders.entity.layers.porcali.PorcaliSaddle;
import com.legacy.glacidus.client.renders.entity.layers.porcali.PorcaliSaddleGlow;
import com.legacy.glacidus.entities.passive.EntityPorcali;

public class PorcaliRenderer extends RenderLiving<EntityPorcali>
{

	private static final ResourceLocation TEXTURE = new ResourceLocation("glacidus", "textures/entity/porcali/porcali.png");

	public PorcaliRenderer(RenderManager rendermanagerIn)
	{
		super(rendermanagerIn, new ModelPorcali(0.0F), 0.7F);
        this.addLayer(new PorcaliGlow((this)));
        this.addLayer(new PorcaliSaddle((this)));
        this.addLayer(new PorcaliSaddleGlow((this)));
	}
	
	protected void scalePorc(EntityPorcali porc)
	{

		GlStateManager.scale(1.3F, 1.3F, 1.3F);
	}

	@Override
	protected void preRenderCallback(EntityPorcali entityliving, float f)
	{
		this.scalePorc(entityliving);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPorcali entity)
	{
		return TEXTURE;
	}

}