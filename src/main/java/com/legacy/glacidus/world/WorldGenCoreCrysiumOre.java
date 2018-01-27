package com.legacy.glacidus.world;

import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class WorldGenCoreCrysiumOre extends WorldGenerator
{

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (!worldIn.isAirBlock(position))
        {
            return false;
        }
        else if (worldIn.getBlockState(position.up()).getBlock() != BlocksGlacidus.frozen_antinatric_stone)
        {
            return false;
        }
        else
        {
            worldIn.setBlockState(position, BlocksGlacidus.crysium_ore.getDefaultState(), 2);

            for (int i = 0; i < 1500; ++i)
            {
                BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));

                if (worldIn.isAirBlock(blockpos))
                {
                    int j = 0;

                    for (EnumFacing enumfacing : EnumFacing.values())
                    {
                        if (worldIn.getBlockState(blockpos.offset(enumfacing)).getBlock() == BlocksGlacidus.crysium_ore)
                        {
                            ++j;
                        }

                        if (j > 1)
                        {
                            break;
                        }
                    }

                    if (j == 1)
                    {
                        worldIn.setBlockState(blockpos, BlocksGlacidus.crysium_ore.getDefaultState(), 2);
                    }
                }
            }

            return true;
        }
    }

}