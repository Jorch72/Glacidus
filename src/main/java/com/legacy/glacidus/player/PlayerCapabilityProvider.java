package com.legacy.glacidus.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerCapabilityProvider implements ICapabilitySerializable<NBTTagCompound>
{

	private PlayerCapability capability;

	public PlayerCapabilityProvider(EntityPlayer player)
	{
		this.capability = new PlayerCapability(player);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == PlayerRegistry.PLAYER_CAPABILITY;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if (capability == PlayerRegistry.PLAYER_CAPABILITY)
		{
			return (T) this.capability;
		}

		return null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		NBTTagCompound compound = new NBTTagCompound();

		if (this.capability != null)
		{
			this.capability.writeCapabilityToNBT(compound);
		}

		return compound;
	}

	@Override
	public void deserializeNBT(NBTTagCompound compound) 
	{
		if (this.capability != null)
		{
			this.capability.readCapabilityFromNBT(compound);
		}
	}

}