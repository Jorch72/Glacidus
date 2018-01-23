package com.legacy.glacidus.blocks.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialGlacidusLiquid extends MaterialLiquid
{

	public MaterialGlacidusLiquid()
	{
		super(MapColor.ICE);

		this.setNoPushMobility();
	}

}