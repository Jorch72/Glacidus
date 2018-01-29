package com.legacy.glacidus.tiles;

import com.legacy.glacidus.util.ModInfo;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry 
{

	public static void initialization()
	{
		GameRegistry.registerTileEntity(TileEntityGlacidusPortal.class, ModInfo.MOD_ID + ":glacidus_portal");
		GameRegistry.registerTileEntity(TileEntitySolidifier.class, ModInfo.MOD_ID + ":solidifier");
	}
}