package com.legacy.glacidus.blocks.natural;

import net.minecraftforge.fluids.BlockFluidClassic;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.blocks.material.GlacidusMaterial;

public class BlockGlaciumStatic extends BlockFluidClassic
{

	public BlockGlaciumStatic()
	{
		super(BlocksGlacidus.GLACIUM, GlacidusMaterial.GLACIUM);
	}

}