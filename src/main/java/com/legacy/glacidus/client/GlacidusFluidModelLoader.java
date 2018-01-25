package com.legacy.glacidus.client;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelFluid;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class GlacidusFluidModelLoader implements ICustomModelLoader 
{

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) 
	{

	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) 
	{
		if (!modelLocation.getResourceDomain().equals("glacidus"))
		{
			return false;
		}

		return modelLocation.getResourcePath().contains("glacium") || modelLocation.getResourcePath().contains("molten_lava");
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception
	{
		if (modelLocation.getResourcePath().contains("glacium"))
		{
			return new ModelFluid(BlocksGlacidus.GLACIUM);
		}
		else if (modelLocation.getResourcePath().contains("molten_lava"))
		{
			return new ModelFluid(BlocksGlacidus.MOLTEN_LAVA);
		}

		return null;
	}

}
