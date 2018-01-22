package com.legacy.glacidus.blocks;

import com.legacy.glacidus.util.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class BlocksGlacidus 
{

	private static IForgeRegistry<Block> iBlockRegistry;

	private static IForgeRegistry<Item> iItemRegistry;

	public static void initialization()
	{
		if (!readyToInitialize())
		{
			return;
		}

	}

	private static boolean readyToInitialize()
	{
		return iBlockRegistry != null && iItemRegistry != null;
	}

	private static Block register(String unlocalizedName, Block block)
	{
		return register(unlocalizedName, block, new ItemBlock(block));
	}

	private static Block register(String unlocalizedName, Block block, ItemBlock itemBlock)
	{
		block.setUnlocalizedName(unlocalizedName);

		block.setRegistryName(ModInfo.locate(unlocalizedName));
		itemBlock.setRegistryName(ModInfo.locate(unlocalizedName));

		iBlockRegistry.register(block);
		iItemRegistry.register(itemBlock);

		return block;
	}

	public static void setBlockRegistry(IForgeRegistry<Block> iBlockRegistry)
	{
		BlocksGlacidus.iBlockRegistry = iBlockRegistry;
	}

	public static void setItemRegistry(IForgeRegistry<Item> iItemRegistry)
	{
		BlocksGlacidus.iItemRegistry = iItemRegistry;
	}

}