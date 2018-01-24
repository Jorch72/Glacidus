package com.legacy.glacidus.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockUndergroundPlanks extends Block
{

	public BlockUndergroundPlanks()
	{
		super(Material.WOOD);

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}

}