package com.legacy.glacidus.player;

import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.world.TeleporterGlacidus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class PlayerCapability
{

	private EntityPlayer player;

	public PlayerCapability(EntityPlayer player)
	{
		this.player = player;
	}

	public static PlayerCapability get(EntityPlayer player)
	{
		return player.getCapability(PlayerRegistry.PLAYER_CAPABILITY, null);
	}

	public void teleportPlayerToGlacidus()
	{
		if (this.player instanceof EntityPlayerMP)
		{
			int dimensionToTravel = this.player.dimension == ModConfig.dimensionID ? 0 : ModConfig.dimensionID;
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

			if (server != null)
			{
				if (ForgeHooks.onTravelToDimension(this.player, dimensionToTravel))
				{
					server.getPlayerList().transferPlayerToDimension((EntityPlayerMP) this.player, dimensionToTravel, new TeleporterGlacidus(server.getWorld(dimensionToTravel)));
				}
			}
		}
	}

	public void writeCapabilityToNBT(NBTTagCompound compound)
	{
		
	}

	public void readCapabilityFromNBT(NBTTagCompound compound)
	{
		
	}

	public EntityPlayer getPlayer()
	{
		return this.player;
	}

}