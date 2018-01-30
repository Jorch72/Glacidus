package com.legacy.glacidus.client.renders.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import com.legacy.glacidus.client.models.entity.ModelMoose;
import com.legacy.glacidus.client.renders.entity.layers.AntlerGlow;
import com.legacy.glacidus.entities.passive.EntityMerialces;

public class MerialcesRenderer extends RenderLiving<EntityMerialces>
{

	private static final ResourceLocation TEXTURE = new ResourceLocation("glacidus", "textures/entity/merialces/merialces.png");

	public MerialcesRenderer(RenderManager rendermanagerIn)
	{
		super(rendermanagerIn, new ModelMoose(0.0F), 0.7F);
        this.addLayer(new AntlerGlow(this));
	}
	
	protected void scaleMoose(EntityMerialces moose)
	{

		GlStateManager.scale(1.3F, 1.3F, 1.3F);
	}

	@Override
	protected void preRenderCallback(EntityMerialces entityliving, float f)
	{
		this.scaleMoose(entityliving);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMerialces entity)
	{
		return TEXTURE;
	}

}