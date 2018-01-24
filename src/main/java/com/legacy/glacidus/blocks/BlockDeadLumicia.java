package com.legacy.glacidus.blocks;

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
    	return state.getBlock() == BlocksGlacidus.antinatric_stone;
    }

	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}