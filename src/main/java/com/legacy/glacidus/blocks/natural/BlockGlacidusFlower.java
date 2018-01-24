package com.legacy.glacidus.blocks.natural;

import com.legacy.glacidus.blocks.BlocksGlacidus;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BlockGlacidusFlower extends BlockBush
{

	public BlockGlacidusFlower()
	{
		super();

		this.setSoundType(SoundType.STONE);
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