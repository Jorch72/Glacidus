package com.legacy.glacidus.blocks.natural;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAntinatricStone extends Block 
{

	public BlockAntinatricStone() 
	{
		super(Material.ROCK);

		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}

}