package com.legacy.glacidus.entities;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.entities.hostile.EntityDropSpider;
import com.legacy.glacidus.entities.passive.EntityMerialces;
import com.legacy.glacidus.entities.passive.EntityPorcali;
import com.legacy.glacidus.util.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitiesGlacidus 
{

	private static int modEntityId;

	public static void initialization()
	{
		register("drop_spider", EntityDropSpider.class, 0xFFFFF, 0x555555);
		register("porcali", EntityPorcali.class, 0xd4a8fb, 0x3dff66);
		register("merialces", EntityMerialces.class, 0x835235, 0x8ed2f9);
		//register("glimmer", EntityGlimmer.class);
	}

	private static void register(String entityName, Class<? extends Entity> clazz, int primaryEggColor, int secondaryEggColor)
	{
		EntityRegistry.registerModEntity(ModInfo.locate(entityName), clazz, entityName, modEntityId, Glacidus.instance, 80, 3, false, primaryEggColor, secondaryEggColor);

		modEntityId++;
	}

	@SuppressWarnings("unused")
	private static void register(String entityName, Class<? extends Entity> clazz)
	{
		EntityRegistry.registerModEntity(ModInfo.locate(entityName), clazz, entityName, modEntityId, Glacidus.instance, 64, 3, false);

		modEntityId++;
	}

}