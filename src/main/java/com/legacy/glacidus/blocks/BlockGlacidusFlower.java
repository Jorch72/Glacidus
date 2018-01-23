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

    public int getLightValue(IBlockState state)
    {
    	return 21;
    }

    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}