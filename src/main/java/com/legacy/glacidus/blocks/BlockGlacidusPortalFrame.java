package com.legacy.glacidus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockGlacidusPortalFrame extends Block 
{

	public BlockGlacidusPortalFrame()
	{
		super(Material.ROCK);

		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		this.setResistance(99999999F);
	}

}