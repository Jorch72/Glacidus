package com.legacy.glacidus.blocks.natural;

import com.legacy.glacidus.blocks.BlocksGlacidus;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BlockDeadLumicia extends BlockBush
{

	public BlockDeadLumicia()
	{
		super();
	}

	@Override
    protected boolean canSustainBush(IBlockState state)
    {
    	return state.getBlock() == BlocksGlacidus.frozen_antinatric_stone || state.getBlock() == BlocksGlacidus.thawed_antinatric_stone;
    }

	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}