package com.legacy.glacidus.loottables;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

import com.legacy.glacidus.util.ModInfo;

public class GlacidusLootTables 
{

	public static ResourceLocation porcali;

	public static void initialization()
	{
		porcali = get("entities/porcali");
	}
	//wheezing

	public static ResourceLocation get(String location)
	{
		return LootTableList.register(ModInfo.locate(location));
	}

}