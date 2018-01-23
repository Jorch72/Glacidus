package com.legacy.glacidus.world;

import com.legacy.glacidus.Glacidus;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        return new ChunkGeneratorGlacidus(this.world, this.getSeed());
    }

	@Override
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
    	return 0.5F;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
		return 10.0F;
    }

	@Override
    public void getLightmapColors(float partialTicks, float sunBrightness, float skyLight, float blockLight, float[] colors)
    {
    	Glacidus.proxy.handleLightMapColor(partialTicks, colors);
    }

	@Override
	public DimensionType getDimensionType() 
	{
		return WorldGlacidus.dimension;
	}

}