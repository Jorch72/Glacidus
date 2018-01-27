package com.legacy.glacidus.creativetab;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.items.ItemsGlacidus;

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
	public static final CreativeTabs ITEMS = new CreativeTabs("glacidus.items.tab")
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ItemsGlacidus.grapes);
		}
	};
	public static final CreativeTabs TOOLS = new CreativeTabs("glacidus.tools.tab")
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ItemsGlacidus.eukeite_hoe);
		}
	};

}