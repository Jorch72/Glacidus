package com.legacy.glacidus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.client.sounds.MusicHandler;
import com.legacy.glacidus.client.sounds.ambient.LayerAmbientSound;
import paulscode.sound.SoundSystem;

public class ClientEventHandler
{
	private float musicVolume = Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC);

	private float dimTimeInSeconds;

	private long timeAtDim;

	private boolean dimming;

	private String sound;

	private SoundSystem sndSystem;

	private SoundManager sndManager;

	public void dimMusic(float dimTimeInSeconds)
	{
		this.musicVolume = Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC);
		this.dimTimeInSeconds = dimTimeInSeconds;

		this.timeAtDim = System.currentTimeMillis();

		this.dimming = true;
	}

	@SubscribeEvent
	public void onPlayerTick(ClientTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			if (this.dimming)
			{
				long current = System.currentTimeMillis();
				long dif = current - this.timeAtDim;

				if (dif / 1000D >= this.dimTimeInSeconds)
				{
					this.dimming = false;
				}

				this.musicVolume = Math.max(Math.max(0.0F, Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC) * 0.05F), this.musicVolume * 0.95F);
			}
			else
			{
				this.musicVolume = Math.min(Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC), this.musicVolume * 1.05F);
			}

			MusicHandler.getInstance().update();

			if (this.sndManager == null)
			{
				this.sndManager = ObfuscationReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "field_147694_f", "sndManager");
				this.sndSystem = ObfuscationReflectionHelper.getPrivateValue(SoundManager.class, this.sndManager, "field_148620_e", "sndSystem");
			}

			if (this.sound != null)
			{
				this.sndSystem.setVolume(this.sound, this.musicVolume);
			}
		}
	}

	@SubscribeEvent
	public void onSoundPlayed(PlayStreamingSourceEvent event)
	{
		SoundCategory category = event.getSound().getCategory();
		EntityPlayer player = Glacidus.proxy.getPlayer();

		if (player != null && player.dimension == ModConfig.dimensionID && category == SoundCategory.MUSIC)
		{
			if (event.getSound().getSoundLocation().getResourceDomain().equals("glacidus"))
			{
				this.sound = event.getUuid();
			}
		}
	}

	@SubscribeEvent
	public void onSoundPlayed(PlaySoundEvent event)
	{
		SoundCategory category = event.getSound().getCategory();
		EntityPlayer player = Glacidus.proxy.getPlayer();

		if (player != null && player.dimension == ModConfig.dimensionID && category == SoundCategory.MUSIC)
		{
			if (!event.getSound().getSoundLocation().getResourceDomain().equals("glacidus") || (MusicHandler.getInstance().isMusicPlaying() && !(event.getSound() instanceof LayerAmbientSound)))
			{
				event.setResultSound(null);
			}
		}
	}

}