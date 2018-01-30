package com.legacy.glacidus.world.features;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class WorldGenBoosterIsland extends WorldGenerator
{

	@Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        float f = (float)(rand.nextInt(2) + 4);

        for (int i = 0; f > 0.5F; --i)
        {
            for (int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j)
            {
                for (int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k)
                {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(j, i, k), BlocksGlacidus.frozen_antinatric_stone.getDefaultState());
                    }
                }
            }

            f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
        }

        this.setBlockAndNotifyAdequately(worldIn, position.up((int)f + 1), BlocksGlacidus.glacidus_booster.getDefaultState());

        return true;
    }

}