package com.legacy.glacidus.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerCapability
{

	private EntityPlayer player;

	public PlayerCapability(EntityPlayer player)
	{
		this.player = player;
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