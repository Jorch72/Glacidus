package com.legacy.glacidus.entities.util;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.legacy.glacidus.entities.EntityGlacidusAnimal;
import com.legacy.glacidus.player.PlayerCapability;

public class EntityMount extends EntityGlacidusAnimal 
{

    protected float jumpPower;
    
    protected boolean mountJumping;

    protected int field_110285_bP;
    
	public EntityMount(World worldIn)
	{
		super(worldIn);
	}
	
	@Override
    public void travel(float strafe, float vertical, float forward)
	{

		if (this.isBeingRidden() && this.canBeSteered())
		{
			EntityLivingBase entitylivingbase = (EntityLivingBase)this.getPassengers().get(0);

			this.prevRotationYaw = this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationPitch = this.rotationPitch = entitylivingbase.rotationPitch;

			this.rotationYawHead = entitylivingbase.rotationYawHead;

			strafe = entitylivingbase.moveStrafing;
			vertical = entitylivingbase.moveVertical;
			forward = entitylivingbase.moveForward;

			if (forward <= 0.0F)
			{
				forward *= 0.25F;
				this.field_110285_bP = 0;
			}
			
			EntityPlayer player = (EntityPlayer)this.getPassengers().get(0);
		    
		    if (PlayerCapability.get(player).isJumping() && this.onGround)
			{
				this.jump();
			}

	        double d01 = entitylivingbase.posX - this.posX;
	        double d2 = entitylivingbase.posZ - this.posZ;

	        MathHelper.atan2(d2, d01);

			if (this.jumpPower > 0.0F)
			{
				this.motionY = this.getModifiedJumpStrength() * (double) this.jumpPower;

				if (this.isPotionActive(MobEffects.JUMP_BOOST))
				{
					this.motionY += (double) ((float) (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
				}

				
				this.isAirBorne = true;

				this.jumpPower = 0.0F;

				if (!this.world.isRemote)
				{
					this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
				}
			}

			this.motionX *= 0.35F;
			this.motionZ *= 0.35F;
						
			this.stepHeight = 1.0F;
			if (!this.world.isRemote)
			{
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.6F;
				super.travel(strafe, vertical, forward);
			}

			if (this.onGround)
			{
				this.jumpPower = 0.0F;
				this.setJumping(false);
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d0 = this.posX - this.prevPosX;
			double d1 = this.posZ - this.prevPosZ;
			float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;

			if (f4 > 1.0F)
			{
				f4 = 1.0F;
			}

			this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		else
		{
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(strafe, vertical, forward);
		}
	}

	@Override
    public boolean canBeSteered()
    {
        return true;
    }

	protected double getModifiedJumpStrength()
    {
        return 0.4D;
    }

    protected double getModifiedMovementSpeed()
    {
        return (0.4D);
    }

	@Override
    public float getAIMoveSpeed()
    {
        return 0.30F;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return null;
	}

}