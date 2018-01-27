package com.legacy.glacidus.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.client.sounds.MusicHandler;
import com.legacy.glacidus.client.sounds.ambient.LayerAmbientSound;

public class ClientEventHandler
{

	@SubscribeEvent
	public void onPlayerTick(ClientTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			MusicHandler.getInstance().update();
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

			return;
		}
	}

}