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
		ModUtils.registerEvent(new ClientEventHandler());
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
			colors[0] = colors[0] + 0.10F;
			colors[1] = colors[1] + 0.09F;
			colors[2] = colors[2] + 0.15F;
			/*//colors[0] = 1.0F;
			//colors[1] = 1.0F;
			//colors[2] = 1.0F;
			if (player.posY > 60)
			{
				colors[0] = colors[0] + 0.10F;
				colors[1] = colors[1] + 0.09F;
				colors[2] = colors[2] + 0.15F;
			}
			else
			{
				float light = 0.20F;

				if (player.posY <= 60 && player.posY >= 40)
				{
					light = (float) (60.0F - player.posY) / 100.0F;
				}

				colors[0] = colors[0] + light + (light / 2.0F) + 0.05F;
				colors[1] = colors[1] + light +  0.09F;
				colors[2] = colors[2] + light +  0.05F;
			}*/
		}
	}

}