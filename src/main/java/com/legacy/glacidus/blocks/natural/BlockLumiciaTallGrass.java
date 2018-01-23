package com.legacy.glacidus.blocks.natural;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class BlockLumiciaTallGrass extends BlockBush
{

	public BlockLumiciaTallGrass()
	{
		super();
	}

	@Override
    protected boolean canSustainBush(IBlockState state)
    {
    	return state.getBlock() == BlocksGlacidus.lumicia_grass || state.getBlock() == BlocksGlacidus.lumicia_grass;
    }

	@Override
    public int getLightValue(IBlockState state)
    {
    	return 20;
    }

	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}