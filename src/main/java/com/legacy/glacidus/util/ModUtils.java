package com.legacy.glacidus.util;

import net.minecraftforge.common.MinecraftForge;

public class ModUtils 
{

	public static void registerEvent(Object object)
	{
		MinecraftForge.EVENT_BUS.register(object);
	}

}