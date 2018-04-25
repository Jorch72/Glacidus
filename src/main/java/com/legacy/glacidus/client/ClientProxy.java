package com.legacy.glacidus.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.FMLClientHandler;

import com.legacy.glacidus.CommonProxy;
import com.legacy.glacidus.client.renders.BlockRenders;
import com.legacy.glacidus.client.renders.EntityRenders;
import com.legacy.glacidus.client.renders.ItemRenders;
import com.legacy.glacidus.util.ModUtils;

public class ClientProxy extends CommonProxy
{

	private ClientEventHandler clientEventHandler;

	@Override
	public ClientEventHandler getClientEventHandler()
	{
		return this.clientEventHandler;
	}

	@Override
	public void preInitialization()
	{
		ModUtils.registerEvent(new BlockRenders());
		ModUtils.registerEvent(new ItemRenders());

		EntityRenders.initialization();

		ModelLoaderRegistry.registerLoader(new GlacidusFluidModelLoader());
	}

	@Override
	public void initialization()
	{
		this.clientEventHandler = new ClientEventHandler();

		ModUtils.registerEvent(this.clientEventHandler);
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
			//Surface
			if (player.posY > 74)
			{				
				colors[0] = colors[0] + 0.10F;
				colors[1] = colors[1] + 0.09F;
				colors[2] = colors[2] + 0.15F;
			}
			//Middle
			else if (player.posY > 26)
			{
				float light = 0.03F;
				
				colors[0] = colors[0] + light + 0.10F;
				colors[1] = colors[1] + light + 0.09F;
				colors[2] = colors[2] + light + 0.15F;
			}
			//Core
			else
			{
				float light = 0.20F;
				colors[0] = colors[0] + light + (light / 2.0F) + 1.0F;
				colors[1] = colors[1] + light +  0F;
				colors[2] = colors[2] + light +  0F;
			}
		}
	}

}