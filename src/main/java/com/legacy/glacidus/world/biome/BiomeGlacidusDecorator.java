package com.legacy.glacidus.world.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.world.features.WorldGenCoreFlowers;
import com.legacy.glacidus.world.features.WorldGenCoreMinable;
import com.legacy.glacidus.world.features.WorldGenTopSpikes;

public class BiomeGlacidusDecorator extends BiomeDecorator
{

	public WorldGenCoreFlowers coreFlowerGen = new WorldGenCoreFlowers(BlocksGlacidus.crysial_flower);

	public WorldGenTopSpikes spikeGen = new WorldGenTopSpikes();

	public WorldGenCoreMinable dirtGen = new WorldGenCoreMinable(BlocksGlacidus.lumicia_dirt.getDefaultState(), 32);

	public WorldGenCoreMinable eukieteGen = new WorldGenCoreMinable(BlocksGlacidus.eukeite_ore.getDefaultState(), 10);
	
	public WorldGenCoreMinable glaciditeGen = new WorldGenCoreMinable(BlocksGlacidus.glacidite_ore.getDefaultState(), 5);

	@Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random)
    {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(worldIn, random, this.chunkPos));

        this.generateOres(worldIn, random);
        
        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, this.chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE))
        {
            if (random.nextInt(3) == 0)
            {
                int j = random.nextInt(16) + 8;
                int k = random.nextInt(16) + 8;
                this.spikeGen.generate(worldIn, random, this.chunkPos.add(j, random.nextInt(75) + 140, k));
            }
        }

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, this.chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
        {
        	for (int j2 = 0; j2 < 15; ++j2)
            {
                int k6 = random.nextInt(16) + 8;
                int l = random.nextInt(16) + 8;
                WorldGenAbstractTree worldgenabstracttree = biomeIn.getRandomTreeFeature(random);
                worldgenabstracttree.setDecorationDefaults();
                BlockPos blockpos = this.chunkPos.add(k6, random.nextInt(30) + 30, l);

                if (worldgenabstracttree.generate(worldIn, random, blockpos))
                {
                    worldgenabstracttree.generateSaplings(worldIn, random, blockpos);
                }
            }
        }

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, this.chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
        {
            for (int l2 = 0; l2 < 5; ++l2)
            {
                int i7 = random.nextInt(16) + 8;
                int l10 = random.nextInt(16) + 8;
                int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

                if (j14 > 0)
                {
                    this.coreFlowerGen.setGeneratedBlock(BlocksGlacidus.dead_lumicia);
                    this.coreFlowerGen.generate(worldIn, random, this.chunkPos.add(i7, random.nextInt(j14), l10));
                }
            }

            for (int l2 = 0; l2 < 5; ++l2)
            {
                int i7 = random.nextInt(16) + 8;
                int l10 = random.nextInt(16) + 8;
                int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

                if (j14 > 0)
                {
                    this.coreFlowerGen.setGeneratedBlock(BlocksGlacidus.crysial_flower);
                    this.coreFlowerGen.generate(worldIn, random, this.chunkPos.add(i7, random.nextInt(j14), l10));
                }
            }

            for (int l2 = 0; l2 < 4; ++l2)
            {
                int i7 = random.nextInt(16) + 8;
                int l10 = random.nextInt(16) + 8;
                int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

                if (j14 > 0)
                {
                    this.coreFlowerGen.setGeneratedBlock(BlocksGlacidus.pulphorus_flower);
                    this.coreFlowerGen.generate(worldIn, random, this.chunkPos.add(i7, random.nextInt(j14), l10));
                }
            }

            for (int l2 = 0; l2 < 2; ++l2)
            {
                int i7 = random.nextInt(16) + 8;
                int l10 = random.nextInt(16) + 8;
                int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

                if (j14 > 0)
                {
                    this.coreFlowerGen.setGeneratedBlock(BlocksGlacidus.solegia_flower);
                    this.coreFlowerGen.generate(worldIn, random, this.chunkPos.add(i7, random.nextInt(j14), l10));
                }
            }
        }

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
        {
            for (int i3 = 0; i3 < 8; ++i3)
            {
                int j7 = random.nextInt(16) + 8;
                int i11 = random.nextInt(16) + 8;
                int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;

                if (k14 > 0)
                {
                    int l17 = random.nextInt(k14);
                    biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random, this.chunkPos.add(j7, l17, i11));
                }
            }
        }

        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(worldIn, random, this.chunkPos));
    }

	@Override
    protected void generateOres(World worldIn, Random random)
    {
        net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Pre(worldIn, random, this.chunkPos));
        if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, this.dirtGen, this.chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
        this.genStandardOre1(worldIn, random, 20, this.dirtGen, 28, 70);
        if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, this.eukieteGen, this.chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
        this.genStandardOre1(worldIn, random, 6, this.eukieteGen, 28, 72);
        net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, random, this.chunkPos));
        
        //this.genStandardOre1(worldIn, random, 6, this.glaciditeGen, 73, 90);
       // net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, random, this.chunkPos));
    }
}