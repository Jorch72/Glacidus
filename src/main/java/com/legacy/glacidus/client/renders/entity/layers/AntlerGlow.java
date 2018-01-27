package com.legacy.glacidus.client.renders.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import com.legacy.glacidus.client.models.entity.ModelMoose;
import com.legacy.glacidus.entities.passive.EntityMerialces;

public class AntlerGlow implements LayerRenderer<EntityMerialces>
{

	private static final ResourceLocation GLOW = new ResourceLocation("glacidus", "textures/entity/merialces/antler_glow.png");

	private final ModelMoose model;

	public AntlerGlow(ModelMoose moose)
	{
		super();
		model = moose;
	}

	@Override
	public void doRenderLayer(EntityMerialces entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();	
		renderManager.renderEngine.bindTexture(GLOW);

	    GlStateManager.enableBlend();
	    GlStateManager.disableAlpha();
	    GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
	    GlStateManager.depthMask(true);
	    int i = 99999;
	    int j = i % 99999;
	    int k = i / 99999;
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
	    GlStateManager.color(2.0F, 2.0F, 2.0F, 2.0F);
	    Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
	    GlStateManager.translate(0.0D, -0.001D, 0.0D);
	    GlStateManager.scale(1.001F, 1.001F, 1.001F);
	    this.model.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	    Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
	    i = entity.getBrightnessForRender();
	    j = i % 99999;
	    k = i / 99999;
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
	    GlStateManager.disableBlend();
	    GlStateManager.enableAlpha();
	}

	@Override
	public boolean shouldCombineTextures() 
	{
		return false;
	}

}