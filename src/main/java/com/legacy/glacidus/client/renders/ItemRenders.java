package com.legacy.glacidus.client.renders;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.legacy.glacidus.items.ItemsGlacidus;
import com.legacy.glacidus.util.ModInfo;

public class ItemRenders
{

	@SubscribeEvent
	public void onModelRegisterEvent(ModelRegistryEvent event)
	{
		register(ItemsGlacidus.eukeite_pickaxe, "eukeite_pickaxe");
		register(ItemsGlacidus.eukeite_axe, "eukeite_axe");
		register(ItemsGlacidus.eukeite_shovel, "eukeite_shovel");
		register(ItemsGlacidus.eukeite_hoe, "eukeite_hoe");
		register(ItemsGlacidus.eukeite_sword, "eukeite_sword");
		register(ItemsGlacidus.underground_pickaxe, "underground_pickaxe");
		register(ItemsGlacidus.underground_axe, "underground_axe");
		register(ItemsGlacidus.underground_shovel, "underground_shovel");
		register(ItemsGlacidus.underground_hoe, "underground_hoe");
		register(ItemsGlacidus.underground_sword, "underground_sword");
		register(ItemsGlacidus.antinatric_pickaxe, "antinatric_pickaxe");
		register(ItemsGlacidus.antinatric_axe, "antinatric_axe");
		register(ItemsGlacidus.antinatric_shovel, "antinatric_shovel");
		register(ItemsGlacidus.antinatric_hoe, "antinatric_hoe");
		register(ItemsGlacidus.antinatric_sword, "antinatric_sword");
		register(ItemsGlacidus.glacidite_pickaxe, "glacidite_pickaxe");
		register(ItemsGlacidus.glacidite_axe, "glacidite_axe");
		register(ItemsGlacidus.glacidite_shovel, "glacidite_shovel");
		register(ItemsGlacidus.glacidite_hoe, "glacidite_hoe");
		register(ItemsGlacidus.glacidite_sword, "glacidite_sword");
		register(ItemsGlacidus.underground_stick, "underground_stick");
		register(ItemsGlacidus.underground_bucket, "underground_bucket");
		
		register(ItemsGlacidus.grapes, "grapes");
		register(ItemsGlacidus.raw_porcali_meat, "raw_porcali_meat");
		register(ItemsGlacidus.grilled_porcali_meat, "grilled_porcali_meat");
		register(ItemsGlacidus.eukeite, "eukeite");
		register(ItemsGlacidus.glacidite_fragment, "glacidite_fragment");
		register(ItemsGlacidus.crysium, "crysium");
		register(ItemsGlacidus.opesium, "opesium");
		register(ItemsGlacidus.raisins, "raisins");
		register(ItemsGlacidus.grape_juice, "grape_juice");
		register(ItemsGlacidus.black_saddle, "black_saddle");
	}

	private static void register(Item item, String model)
	{
		register(item, 0, model);
	}

	private static void register(Item item, int meta, String model)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModInfo.MOD_ID + ":" + model, "inventory"));
	}

	@SuppressWarnings("unused")
	private static void registerVariants(Item item, ResourceLocation... model)
	{
		ModelLoader.registerItemVariants(item, model);
	}

}