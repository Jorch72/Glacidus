package com.legacy.glacidus.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockUndergroundDoor extends BlockDoor
{

	public BlockUndergroundDoor()
	{
		super(Material.WOOD);

		this.setHardness(3.0F);
		this.setSoundType(SoundType.WOOD);
	}

}