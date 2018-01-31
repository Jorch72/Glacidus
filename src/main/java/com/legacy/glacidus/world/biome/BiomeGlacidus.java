package com.legacy.glacidus.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.google.common.collect.Lists;
import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.entities.passive.EntityPorcali;
import com.legacy.glacidus.entities.passive.EntityMerialces;
import com.legacy.glacidus.util.ModInfo;
import com.legacy.glacidus.world.features.WorldGenCoreTallGrass;
import com.legacy.glacidus.world.features.WorldGenCoreVines;
import com.legacy.glacidus.world.features.WorldGenUndergroundTree;

public class BiomeGlacidus extends Biome
{

	public BiomeGlacidus()
	{
		super(new BiomeProperties("glacidus").setRainDisabled().setWaterColor(0xFFFFFF));

		this.setRegistryName(ModInfo.locate("glacidus"));

		this.addSpawnableCreatureList();
	}

	public void addSpawnableCreatureList()
	{
		ArrayList<SpawnListEntry> entityList = new ArrayList<SpawnListEntry>();

		entityList.add(new Biome.SpawnListEntry(EntityPorcali.class, 7, 2, 3));
		entityList.add(new Biome.SpawnListEntry(EntityMerialces.class, 5, 1, 2));
		
		this.modSpawnableLists.put(EnumCreatureType.CREATURE, entityList);
	}

	@Override
    public int getWaterColorMultiplier()
    {
    	return 0xFF5555;
    }

	@Override
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);

        WorldGenCoreVines worldgenvines = new WorldGenCoreVines(rand.nextInt(10) == 0 ? BlocksGlacidus.lumicia_grape_vine : BlocksGlacidus.lumicia_vine);

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
        for (int j1 = 0; j1 < 30; ++j1)
        {
            int k = rand.nextInt(16) + 8;
            int i1 = rand.nextInt(16) + 8;
            worldgenvines.generate(worldIn, rand, pos.add(k, 50, i1));
        }
    }

	@Override
    public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType)
    {
        if (!this.modSpawnableLists.containsKey(creatureType)) this.modSpawnableLists.put(creatureType, Lists.<SpawnListEntry>newArrayList());

        return this.modSpawnableLists.get(creatureType);
    }
 
	@Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return new WorldGenUndergroundTree();
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