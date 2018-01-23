package com.legacy.glacidus.blocks;

import com.legacy.glacidus.blocks.natural.BlockAntinatricStone;
import com.legacy.glacidus.blocks.natural.BlockLumiciaDirt;
import com.legacy.glacidus.blocks.natural.BlockLumiciaGrass;
import com.legacy.glacidus.util.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

public class BlocksGlacidus 
{

	private static IForgeRegistry<Block> iBlockRegistry;

	private static IForgeRegistry<Item> iItemRegistry;

	@ObjectHolder(ModInfo.MOD_ID + ":small_crystal")
	public static Block small_crystal;

	@ObjectHolder(ModInfo.MOD_ID + ":crysial_flower")
	public static Block crysial_flower;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidus_portal")
	public static Block glacidus_portal;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_grass")
	public static Block lumicia_grass;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_dirt")
	public static Block lumicia_dirt;

	@ObjectHolder(ModInfo.MOD_ID + ":antinatric_stone")
	public static Block antinatric_stone;

	public static void initialization()
	{
		if (!readyToInitialize())
		{
			return;
		}

		small_crystal = register("small_crystal", new BlockSmallCrystal());

		crysial_flower = register("crysial_flower", new BlockGlacidusFlower());

		glacidus_portal  = register("glacidus_portal", new BlockGlacidusPortal());

		lumicia_grass = register("lumicia_grass", new BlockLumiciaGrass());
		lumicia_dirt = register("lumicia_dirt", new BlockLumiciaDirt());
		antinatric_stone = register("antinatric_stone", new BlockAntinatricStone());
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