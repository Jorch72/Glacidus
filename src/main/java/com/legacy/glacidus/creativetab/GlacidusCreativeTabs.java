package com.legacy.glacidus.creativetab;

import com.legacy.glacidus.blocks.BlocksGlacidus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GlacidusCreativeTabs 
{

	public static final CreativeTabs BLOCKS = new CreativeTabs("glacidus.blocks.tab")
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(BlocksGlacidus.lumicia_grass);
		}
	};

}