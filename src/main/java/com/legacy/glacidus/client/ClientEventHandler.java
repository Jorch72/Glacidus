package com.legacy.glacidus.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.client.sounds.MusicHandler;

public class ClientEventHandler
{

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		if (event.player != null)
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
			if (!event.getSound().getSoundLocation().getResourceDomain().equals("glacidus"))
			{
				System.out.println(event.getSound().getSoundLocation().toString());
				event.setResultSound(null);
			}

			return;
		}
	}

}