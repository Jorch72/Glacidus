package com.legacy.glacidus.world.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.world.features.WorldGenCoreFlowers;

public class BiomeGlacidusDecorator extends BiomeDecorator
{

	public WorldGenCoreFlowers coreFlowerGen = new WorldGenCoreFlowers(BlocksGlacidus.crysial_flower);

	@Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random)
    {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(worldIn, random, this.chunkPos));

        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, this.chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
        {
            for (int j2 = 0; j2 < 10; ++j2)
            {
                int k6 = random.nextInt(16) + 8;
                int l = random.nextInt(16) + 8;
                WorldGenAbstractTree worldgenabstracttree = biomeIn.getRandomTreeFeature(random);
                worldgenabstracttree.setDecorationDefaults();
                BlockPos blockpos = this.chunkPos.add(k6, random.nextInt(31) + 70, l);

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

}