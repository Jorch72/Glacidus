package com.legacy.glacidus.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BlockGlacidusFlower extends BlockBush
{

	public BlockGlacidusFlower()
	{
		super();
	}

	@Override
    protected boolean canSustainBush(IBlockState state)
    {
    	return state.getBlock() == BlocksGlacidus.lumicia_grass || state.getBlock() == BlocksGlacidus.lumicia_grass;
    }

	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}