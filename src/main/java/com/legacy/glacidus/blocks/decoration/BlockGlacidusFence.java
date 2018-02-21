package com.legacy.glacidus.blocks.decoration;

import com.legacy.glacidus.creativetab.GlacidusCreativeTabs;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockGlacidusFence extends BlockFence
{

	public BlockGlacidusFence()
	{
		super(Material.WOOD, MapColor.WOOD);

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
		this.setCreativeTab(GlacidusCreativeTabs.BLOCKS);
	}

}