package com.legacy.glacidus.client.renders.entity.layers.porcali;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import com.legacy.glacidus.client.models.entity.ModelPorcali;
import com.legacy.glacidus.client.renders.entity.PorcaliRenderer;
import com.legacy.glacidus.entities.passive.EntityPorcali;

public class PorcaliSaddle implements LayerRenderer<EntityPorcali>
{

	private static final ResourceLocation SADDLE = new ResourceLocation("glacidus", "textures/entity/porcali/saddle/porcali_saddle.png");

	private final PorcaliRenderer renderer;
	private final ModelPorcali model = new ModelPorcali(0.5F);

	public PorcaliSaddle(PorcaliRenderer porc)
	{
		super();
		
		this.renderer = porc;
	}

	@Override
	public void doRenderLayer(EntityPorcali entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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