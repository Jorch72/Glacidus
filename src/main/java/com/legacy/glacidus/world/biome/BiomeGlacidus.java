package com.legacy.glacidus.world.biome;

import com.legacy.glacidus.util.ModInfo;

import net.minecraft.world.biome.Biome;

public class BiomeGlacidus extends Biome
{

	public BiomeGlacidus()
	{
		super(new BiomeProperties("glacidus").setRainDisabled().setWaterColor(0xE0FFFF));

		this.setRegistryName(ModInfo.locate("glacidus"));
	}

}