package com.legacy.glacidus.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.registries.IForgeRegistry;

import com.legacy.glacidus.creativetab.GlacidusCreativeTabs;
import com.legacy.glacidus.items.tools.axes.ItemAntinatricAxe;
import com.legacy.glacidus.items.tools.axes.ItemEukeiteAxe;
import com.legacy.glacidus.items.tools.axes.ItemGlaciditeAxe;
import com.legacy.glacidus.items.tools.axes.ItemUndergroundAxe;
import com.legacy.glacidus.items.tools.hoes.ItemAntinatricHoe;
import com.legacy.glacidus.items.tools.hoes.ItemEukeiteHoe;
import com.legacy.glacidus.items.tools.hoes.ItemGlaciditeHoe;
import com.legacy.glacidus.items.tools.hoes.ItemUndergroundHoe;
import com.legacy.glacidus.items.tools.pickaxes.ItemAntinatricPickaxe;
import com.legacy.glacidus.items.tools.pickaxes.ItemEukeitePickaxe;
import com.legacy.glacidus.items.tools.pickaxes.ItemGlaciditePickaxe;
import com.legacy.glacidus.items.tools.pickaxes.ItemUndergroundPickaxe;
import com.legacy.glacidus.items.tools.shovels.ItemAntinatricShovel;
import com.legacy.glacidus.items.tools.shovels.ItemEukeiteShovel;
import com.legacy.glacidus.items.tools.shovels.ItemGlaciditeShovel;
import com.legacy.glacidus.items.tools.shovels.ItemUndergroundShovel;
import com.legacy.glacidus.items.weapons.ItemAntinatricSword;
import com.legacy.glacidus.items.weapons.ItemEukeiteSword;
import com.legacy.glacidus.items.weapons.ItemGlaciditeSword;
import com.legacy.glacidus.items.weapons.ItemUndergroundSword;
import com.legacy.glacidus.util.ModInfo;

public class ItemsGlacidus 
{
	private static IForgeRegistry<Item> iItemRegistry;

	public static Item eukeite_pickaxe, eukeite_axe, eukeite_shovel, eukeite_hoe, eukeite_sword;

	public static Item underground_pickaxe, underground_axe, underground_shovel, underground_hoe, underground_sword;
	
	public static Item antinatric_pickaxe, antinatric_axe, antinatric_shovel, antinatric_hoe, antinatric_sword;
	
	public static Item glacidite_pickaxe, glacidite_axe, glacidite_shovel, glacidite_hoe, glacidite_sword;
		
	public static Item grapes, raw_porcali_meat, grilled_porcali_meat, grape_juice, raisins;
	
	public static Item eukeite, glacidite_fragment, crysium;
	
	public static Item black_saddle;

	public static void initialization()
	{
		eukeite_pickaxe = registerTool("eukeite_pickaxe", new ItemEukeitePickaxe());
		eukeite_axe = registerTool("eukeite_axe", new ItemEukeiteAxe());
		eukeite_shovel = registerTool("eukeite_shovel", new ItemEukeiteShovel());
		eukeite_hoe = registerTool("eukeite_hoe", new ItemEukeiteHoe());
		eukeite_sword = registerTool("eukeite_sword", new ItemEukeiteSword());
		underground_pickaxe = registerTool("underground_pickaxe", new ItemUndergroundPickaxe());
		underground_axe = registerTool("underground_axe", new ItemUndergroundAxe());
		underground_shovel = registerTool("underground_shovel", new ItemUndergroundShovel());
		underground_hoe = registerTool("underground_hoe", new ItemUndergroundHoe());
		underground_sword = registerTool("underground_sword", new ItemUndergroundSword());
		antinatric_pickaxe = registerTool("antinatric_pickaxe", new ItemAntinatricPickaxe());
		antinatric_axe = registerTool("antinatric_axe", new ItemAntinatricAxe());
		antinatric_shovel = registerTool("antinatric_shovel", new ItemAntinatricShovel());
		antinatric_hoe = registerTool("antinatric_hoe", new ItemAntinatricHoe());
		antinatric_sword = registerTool("antinatric_sword", new ItemAntinatricSword());
		glacidite_pickaxe = registerTool("glacidite_pickaxe", new ItemGlaciditePickaxe());
		glacidite_axe = registerTool("glacidite_axe", new ItemGlaciditeAxe());
		glacidite_shovel = registerTool("glacidite_shovel", new ItemGlaciditeShovel());
		glacidite_hoe = registerTool("glacidite_hoe", new ItemGlaciditeHoe());
		glacidite_sword = registerTool("glacidite_sword", new ItemGlaciditeSword());

		grapes = register("grapes", new ItemFood(2, false));
		grape_juice = register("grape_juice", new ItemGrapeJuice());
		raisins = register("raisins", new ItemFood(3, false));
		raw_porcali_meat = register("raw_porcali_meat", new ItemFood(3, true));
		grilled_porcali_meat = register("grilled_porcali_meat", new ItemFood(6, true));
		eukeite = register("eukeite", new Item());
		crysium = register("crysium", new Item());
		glacidite_fragment = register("glacidite_fragment", new Item());
		
		black_saddle = register("black_saddle", new Item());
	}

	private static Item register(String unlocalizedName, Item item)
	{
		item.setUnlocalizedName(unlocalizedName);

		item.setRegistryName(ModInfo.locate(unlocalizedName));
		item.setCreativeTab(GlacidusCreativeTabs.ITEMS);

		iItemRegistry.register(item);

		return item;
	}
	
	private static Item registerTool(String unlocalizedName, Item item)
	{
		item.setUnlocalizedName(unlocalizedName);

		item.setRegistryName(ModInfo.locate(unlocalizedName));
		item.setCreativeTab(GlacidusCreativeTabs.TOOLS);

		iItemRegistry.register(item);

		return item;
	}

	public static void setItemRegistry(IForgeRegistry<Item> iItemRegistry)
	{
		ItemsGlacidus.iItemRegistry = iItemRegistry;
	}

}