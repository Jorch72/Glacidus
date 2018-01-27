package com.legacy.glacidus.world.features;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class WorldGenCoreVines extends WorldGenerator
{

	private Block block;

	public WorldGenCoreVines(Block block)
	{
		this.block = block;
	}

	@Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (; position.getY() < 63; position = position.up())
        {
            if (worldIn.isAirBlock(position))
            {
                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL.facings())
                {
                    if (BlocksGlacidus.lumicia_vine.canPlaceBlockOnSide(worldIn, position, enumfacing))
                    {
                    	enumfacing = enumfacing.getOpposite();
                        IBlockState iblockstate = this.block.getDefaultState().withProperty(BlockVine.NORTH, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(BlockVine.EAST, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(BlockVine.SOUTH, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(BlockVine.WEST, Boolean.valueOf(enumfacing == EnumFacing.WEST));
                        worldIn.setBlockState(position, iblockstate, 2);
                        break;
                    }
                }
            }
        }

        return true;
    }

}