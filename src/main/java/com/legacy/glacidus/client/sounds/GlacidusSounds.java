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

	public static SoundEvent MUSIC_TRACK_ONE;
	public static SoundEvent MUSIC_TRACK_TWO;
	public static SoundEvent MUSIC_TRACK_THREE;
	
	public static SoundEvent MUSIC_DISC_ONE;
	
	public static SoundEvent PORCALI_SAY;
	public static SoundEvent PORCALI_HURT;
	public static SoundEvent PORCALI_DEATH;

	public static void initialization(IForgeRegistry<SoundEvent> registry)
	{
		iSoundRegistry = registry;

		PORCALI_SAY = register("mob.porcali.say");
		PORCALI_HURT = register("mob.porcali.hurt");
		PORCALI_DEATH = register("mob.porcali.death");
		
		BLOCK_GLACIUM_POP = register("block.glacium.pop");
		BLOCK_GLACIUM_AMBIENT = register("block.glacium.ambient");
		
		MUSIC_TRACK_ONE = register("music.track_one");
		MUSIC_TRACK_TWO = register("music.track_two");
		MUSIC_TRACK_THREE = register("music.track_three");
		
		MUSIC_TRACK_THREE = register("music.disc_one");
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