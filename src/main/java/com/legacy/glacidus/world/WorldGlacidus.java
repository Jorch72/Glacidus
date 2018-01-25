package com.legacy.glacidus.world;

import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.world.biome.BiomeGlacidus;

import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;

public class WorldGlacidus
{

	public static Biome baseBiome = new BiomeGlacidus();

	public static DimensionType dimension;

	public static void initialization()
	{
		dimension = DimensionType.register("Glacidus", "_glacidus", ModConfig.dimensionID, WorldProviderGlacidus.class, true);

		DimensionManager.registerDimension(ModConfig.dimensionID, dimension);
	}

}