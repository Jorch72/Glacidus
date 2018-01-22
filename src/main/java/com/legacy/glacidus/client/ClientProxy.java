package com.legacy.glacidus.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;

import com.legacy.glacidus.CommonProxy;
import com.legacy.glacidus.client.renders.BlockRenders;
import com.legacy.glacidus.client.renders.EntityRenders;
import com.legacy.glacidus.client.renders.ItemRenders;
import com.legacy.glacidus.util.ModUtils;

public class ClientProxy extends CommonProxy
{

	@Override
	public void preInitialization()
	{
		ModUtils.registerEvent(new BlockRenders());
		ModUtils.registerEvent(new ItemRenders());

		EntityRenders.initialization();
	}

	@Override
	public void initialization()
	{

	}

	@Override
	public EntityPlayer getPlayer()
	{
		return FMLClientHandler.instance().getClientPlayerEntity();
	}

}