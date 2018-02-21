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
	public static SoundEvent MUSIC_TRACK_FOUR;
	public static SoundEvent MUSIC_TRACK_FIVE;
	
	public static SoundEvent MUSIC_DISC_ONE;
	
	public static SoundEvent PORCALI_SAY;
	public static SoundEvent PORCALI_HURT;
	public static SoundEvent PORCALI_DEATH;
	
	public static SoundEvent BLOCK_GLACIDUS_PORTAL_IDLE;
	public static SoundEvent BLOCK_GLACIDUS_BOOSTER_IDLE;
	public static SoundEvent BLOCK_GLACIDUS_BOOSTER_LAUNCH;
	
	public static SoundEvent MERIALCES_SAY;
	public static SoundEvent MERIALCES_HURT;
	public static SoundEvent MERIALCES_DEATH;

	public static SoundEvent AMBIENT_WIND_HUM;
	
	public static SoundEvent RANDOM_ADVANCEMENT_JINGLE;

	public static void initialization(IForgeRegistry<SoundEvent> registry)
	{
		iSoundRegistry = registry;

		PORCALI_SAY = register("mob.porcali.say");
		PORCALI_HURT = register("mob.porcali.hurt");
		PORCALI_DEATH = register("mob.porcali.death");
		
		MERIALCES_SAY = register("mob.merialces.say");
		MERIALCES_HURT = register("mob.merialces.hurt");
		MERIALCES_DEATH = register("mob.merialces.death");
		
		BLOCK_GLACIUM_POP = register("block.glacium.pop");
		BLOCK_GLACIUM_AMBIENT = register("block.glacium.ambient");
		
		MUSIC_TRACK_ONE = register("music.track_one");
		MUSIC_TRACK_TWO = register("music.track_two");
		MUSIC_TRACK_THREE = register("music.track_three");
		MUSIC_TRACK_FOUR = register("music.track_four");
		MUSIC_TRACK_FIVE = register("music.track_five");
		
		//MUSIC_DISC_ONE = register("music.disc_one");
		AMBIENT_WIND_HUM = register("ambient.wind_hum");
		
		BLOCK_GLACIDUS_PORTAL_IDLE = register("block.glacidus_portal.idle");
		BLOCK_GLACIDUS_BOOSTER_IDLE = register("block.glacidus_booster.idle");
		BLOCK_GLACIDUS_BOOSTER_LAUNCH = register("block.glacidus_portal.launch");
		
		RANDOM_ADVANCEMENT_JINGLE = register("random.advancement_jingle");
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