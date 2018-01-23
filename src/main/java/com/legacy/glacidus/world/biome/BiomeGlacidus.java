package com.legacy.glacidus.world.biome;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.legacy.glacidus.util.ModInfo;

public class BiomeGlacidus extends Biome
{

	public BiomeGlacidus()
	{
		super(new BiomeProperties("glacidus").setRainDisabled().setWaterColor(0xE0FFFF));

		this.setRegistryName(ModInfo.locate("glacidus"));
	}

	@Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return new WorldGenCoreTallGrass();
    }

	@Override
    public BiomeDecorator createBiomeDecorator()
    {
        return new BiomeGlacidusDecorator();
    }

    @Override
    public Class <? extends Biome > getBiomeClass()
    {
    	return BiomeGlacidus.class;
    }

}