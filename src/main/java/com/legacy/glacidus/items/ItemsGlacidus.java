package com.legacy.glacidus.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import com.legacy.glacidus.items.tools.axes.ItemEukeiteAxe;
import com.legacy.glacidus.items.tools.hoes.ItemEukeiteHoe;
import com.legacy.glacidus.items.tools.pickaxes.ItemEukeitePickaxe;
import com.legacy.glacidus.items.tools.shovels.ItemEukeiteShovel;
import com.legacy.glacidus.items.weapons.ItemEukeiteSword;
import com.legacy.glacidus.util.ModInfo;

public class ItemsGlacidus 
{

	private static IForgeRegistry<Item> iItemRegistry;

	public static Item eukeite_pickaxe, eukeite_axe, eukeite_shovel, eukeite_hoe, eukeite_sword;

	public static void initialization()
	{
		eukeite_pickaxe = register("eukeite_pickaxe", new ItemEukeitePickaxe());
		eukeite_axe = register("eukeite_axe", new ItemEukeiteAxe());
		eukeite_shovel = register("eukeite_shovel", new ItemEukeiteShovel());
		eukeite_hoe = register("eukeite_hoe", new ItemEukeiteHoe());
		eukeite_sword = register("eukeite_sword", new ItemEukeiteSword());
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