package com.legacy.glacidus.blocks.natural;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLumiciaDirt extends Block
{

	public BlockLumiciaDirt() 
	{
		super(Material.GROUND);

		this.setHardness(0.5F);
		this.setSoundType(SoundType.GROUND);
	}

}