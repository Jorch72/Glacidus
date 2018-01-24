package com.legacy.glacidus.client.sounds;

import com.legacy.glacidus.util.ModInfo;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class GlacidusSounds 
{

	private static IForgeRegistry<SoundEvent> iSoundRegistry;

	public static SoundEvent BLOCK_GLACIUM_POP;

	public static SoundEvent BLOCK_GLACIUM_AMBIENT;

	public static void initialization(IForgeRegistry<SoundEvent> registry)
	{
		iSoundRegistry = registry;

		BLOCK_GLACIUM_POP = register("block.glacium.pop");
		BLOCK_GLACIUM_AMBIENT = register("block.glacium.ambient");
	}

	private static SoundEvent register(String name)
	{
		ResourceLocation location = ModInfo.locate(name);

		SoundEvent sound = new SoundEvent(location);

		sound.setRegistryName(location);

		iSoundRegistry.register(sound);

		return sound;
	}

}