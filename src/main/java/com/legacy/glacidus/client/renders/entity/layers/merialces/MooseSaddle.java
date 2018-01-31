package com.legacy.glacidus.client.renders.entity.layers.merialces;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import com.legacy.glacidus.client.models.entity.ModelMoose;
import com.legacy.glacidus.client.renders.entity.MerialcesRenderer;
import com.legacy.glacidus.entities.passive.EntityMerialces;

public class MooseSaddle implements LayerRenderer<EntityMerialces>
{

	private static final ResourceLocation SADDLE = new ResourceLocation("glacidus", "textures/entity/merialces/saddle/moose_saddle.png");

	private final MerialcesRenderer renderer;
	private final ModelMoose model = new ModelMoose(0.5F);

	public MooseSaddle(MerialcesRenderer moose)
	{
		super();
		
		this.renderer = moose;
	}

	@Override
	public void doRenderLayer(EntityMerialces entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		if (entity.getSaddled())
        {
            this.renderer.bindTexture(SADDLE);
            this.model.setModelAttributes(this.renderer.getMainModel());
            this.model.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
	}

	@Override
	public boolean shouldCombineTextures() 
	{
		return false;
	}

}