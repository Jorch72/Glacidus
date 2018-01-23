package com.legacy.glacidus.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterGlacidus extends Teleporter
{

	public TeleporterGlacidus(WorldServer worldIn) 
	{
		super(worldIn);
	}

	@Override
    public void placeInPortal(Entity entityIn, float rotationYaw)
    {
        int i = MathHelper.floor(entityIn.posX);
        int k = MathHelper.floor(entityIn.posZ);

        entityIn.setLocationAndAngles((double)i, 254.0D, (double)k, entityIn.rotationYaw, 0.0F);
        entityIn.motionX = 0.0D;
        entityIn.motionY = 0.0D;
        entityIn.motionZ = 0.0D;
    }

	@Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw)
    {
    	return false;
    }

	@Override
    public boolean makePortal(Entity entityIn)
    {
    	return false;
    }

}