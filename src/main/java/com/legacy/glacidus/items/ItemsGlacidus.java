package com.legacy.glacidus.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import com.legacy.glacidus.util.ModInfo;

public class ItemsGlacidus 
{

	private static IForgeRegistry<Item> iItemRegistry;

	public static void initialization()
	{

	}

	private static Item register(String unlocalizedName, Item item)
	{
		item.setUnlocalizedName(unlocalizedName);

		item.setRegistryName(ModInfo.locate(unlocalizedName));

		iItemRegistry.register(item);

		return item;
	}

	public static void setItemRegistry(IForgeRegistry<Item> iItemRegistry)
	{
		ItemsGlacidus.iItemRegistry = iItemRegistry;
	}

}