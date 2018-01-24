package com.legacy.glacidus.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerCapabilityEvents
{

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer)
		{
			PlayerCapability.get((EntityPlayer)event.getEntity()).onUpdate();
		}
	}

}