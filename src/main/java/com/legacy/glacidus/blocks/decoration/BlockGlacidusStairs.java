package com.legacy.glacidus.blocks.decoration;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockGlacidusStairs extends BlockStairs 
{

	public BlockGlacidusStairs(IBlockState modelState)
	{
		super(modelState);
		this.setLightOpacity(0);
	}

}