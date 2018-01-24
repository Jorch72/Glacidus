package com.legacy.glacidus.player;

import com.legacy.glacidus.util.ModUtils;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class PlayerRegistry
{

	@CapabilityInject(PlayerCapability.class)
	public static Capability<PlayerCapability> PLAYER_CAPABILITY = null;

	public static void initialization()
	{
		CapabilityManager.INSTANCE.register(PlayerCapability.class, new Capability.IStorage<PlayerCapability>()
		{
			@Override
			public NBTBase writeNBT(Capability<PlayerCapability> capability, PlayerCapability instance, EnumFacing side) 
			{
				NBTTagCompound compound = new NBTTagCompound();

				if (instance != null) //Not taking chances ~Kino
				{
					instance.writeCapabilityToNBT(compound);
				}

				return compound;
			}

			@Override
			public void readNBT(Capability<PlayerCapability> capability, PlayerCapability instance, EnumFacing side, NBTBase nbt) 
			{
				if (nbt instanceof NBTTagCompound)
				{
					NBTTagCompound compound = (NBTTagCompound) nbt;

					if (instance != null) //Not taking chances ~Kino
					{
						instance.readCapabilityFromNBT(compound);
					}
				}
			}

		}, PlayerCapability.class);

		ModUtils.registerEvent(new PlayerCapabilityEvents());
	}

}