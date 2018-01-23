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

	@Override
	public void handleLightMapColor(float partialTicks, float[] colors)
	{
		EntityPlayer player = this.getPlayer();

		if (player != null)
		{
			//colors[0] = 1.0F;
			//colors[1] = 1.0F;
			//colors[2] = 1.0F;
			if (player.posY < 100.0D)
			{
				double difference = player.posY / 250D;

				colors[0] = colors[0] /2;
				colors[1] = colors[1] /2;
				colors[2] = colors[2] /2;
			}
			else
			{
				colors[2] = 0.25F;
			}
		}
	}

}