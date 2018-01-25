package com.legacy.glacidus.entities;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.entities.passive.EntityPorcali;
import com.legacy.glacidus.util.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitiesGlacidus 
{

	private static int modEntityId;

	public static void initialization()
	{
		register("porcali", EntityPorcali.class, 0xffffff, 0xffffff);
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