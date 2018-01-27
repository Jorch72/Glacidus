package com.legacy.glacidus.loottables;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

import com.legacy.glacidus.util.ModInfo;

public class GlacidusLootTables 
{

	public static ResourceLocation test;

	public static void initialization()
	{
		//test = get("entities/whatever"); There ya go Bailey~ Have fun!
	}

	public static ResourceLocation get(String location)
	{
		return LootTableList.register(ModInfo.locate(location));
	}

}