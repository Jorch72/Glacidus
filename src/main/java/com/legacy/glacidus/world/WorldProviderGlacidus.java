package com.legacy.glacidus.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderGlacidus extends WorldProvider
{

	@Override
    protected void init()
    {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderSingle(WorldGlacidus.baseBiome);
    }

	@Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorGlacidus();
    }

	@Override
	public DimensionType getDimensionType() 
	{
		return WorldGlacidus.dimension;
	}

}