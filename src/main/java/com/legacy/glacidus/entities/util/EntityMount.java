package com.legacy.glacidus.entities.util;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.legacy.glacidus.entities.EntityGlacidusAnimal;

public class EntityMount extends EntityGlacidusAnimal 
{

    protected float jumpPower;

    protected boolean mountJumping;

	public EntityMount(World worldIn)
	{
		super(worldIn);
	}

	public void travel(float strafe, float vertical, float forward)
    {
        if (this.isBeingRidden() && this.canBeSteered())
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.getPassengers().get(0);
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            strafe = entitylivingbase.moveStrafing * 0.5F;
            forward = entitylivingbase.moveForward;

            if (forward <= 0.0F)
            {
                forward *= 0.25F;
            }

            if (this.onGround && this.jumpPower == 0.0F)
            {
                strafe = 0.0F;
                forward = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isJumping() && this.onGround)
            {
            
                if (this.isPotionActive(MobEffects.JUMP_BOOST))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
                }

                this.setJumping(true);
                this.jump();
                this.isAirBorne = true;

                if (forward > 0.0F)
                {
                    float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
                    float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                    this.motionX += (double)(-0.4F * f * this.jumpPower);
                    this.motionZ += (double)(0.4F * f1 * this.jumpPower);
                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (this.canPassengerSteer())
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                super.travel(strafe, vertical, forward);
            }
            else if (entitylivingbase instanceof EntityPlayer)
            {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }

            if (this.onGround)
            {
                this.jumpPower = 0.0F;
                this.setJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F)
            {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
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
        return 0.2D;
    }

    protected double getModifiedMovementSpeed()
    {
        return (0.4D);
    }

	public boolean isJumping()
    {
        return this.mountJumping;
    }

	@Override
	public void setJumping(boolean jumping)
    {
		super.setJumping(jumping);

        this.mountJumping = jumping;
    }

	@Override
    public float getAIMoveSpeed()
    {
        return this.getMountedMoveSpeed();
    }

	public float getMountedMoveSpeed()
	{
		return 0.15F;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return null;
	}

}