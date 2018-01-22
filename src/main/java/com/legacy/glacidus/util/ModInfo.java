package com.legacy.glacidus.util;

import net.minecraft.util.ResourceLocation;

public class ModInfo
{

	public static final String MOD_ID = "glacidus";

	public static final String NAME = "Glacidus";

	public static final String VERSION = "1.12.2-v1.0";

	public static ResourceLocation locate(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}

}