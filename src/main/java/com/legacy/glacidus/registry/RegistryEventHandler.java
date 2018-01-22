package com.legacy.glacidus.registry;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.items.ItemsGlacidus;
import com.legacy.glacidus.player.PlayerCapabilityProvider;
import com.legacy.glacidus.util.ModInfo;
import com.legacy.glacidus.world.WorldGlacidus;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegistryEventHandler 
{

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event)
	{
		if (event.getObject() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getObject();

			event.addCapability(ModInfo.locate("playerCapability"), new PlayerCapabilityProvider(player));
		}
	}

	@SubscribeEvent
	public void onRegisterBlocks(RegistryEvent.Register<Block> event)
	{
		BlocksGlacidus.setBlockRegistry(event.getRegistry());

		BlocksGlacidus.initialization();
	}

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		BlocksGlacidus.setItemRegistry(event.getRegistry());
		ItemsGlacidus.setItemRegistry(event.getRegistry());

		BlocksGlacidus.initialization();
		ItemsGlacidus.initialization();
	}

	@SubscribeEvent
	public void onRegisterBiomes(RegistryEvent.Register<Biome> event)
	{
		event.getRegistry().register(WorldGlacidus.baseBiome);
	}

}