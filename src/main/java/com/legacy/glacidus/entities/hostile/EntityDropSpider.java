package com.legacy.glacidus.entities.hostile;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityDropSpider extends EntityMob
{

	public EntityDropSpider(World worldIn) 
	{
		super(worldIn);

		this.setNoAI(true);
	}

}