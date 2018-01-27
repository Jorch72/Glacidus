package com.legacy.glacidus.blocks.natural;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCrysiumOre extends Block
{

	public BlockCrysiumOre()
	{
		super(Material.ROCK);

		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setLightLevel(1F);
	}

}