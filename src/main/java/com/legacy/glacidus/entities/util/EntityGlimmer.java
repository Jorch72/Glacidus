package com.legacy.glacidus.entities.util;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGlimmer extends Entity
{
    public int glimmerColor;
    public int orbAge;
    public int delayBeforeCanPickup;
    private int orbHealth = 5;
    private EntityPlayer closestPlayer;
    private int targetColor;

    public EntityGlimmer(World worldIn, double x, double y, double z, int expValue)
    {
        super(worldIn);
        this.setSize(0.5F, 0.5F);
        this.setPosition(x, y, z);
        this.rotationYaw = (float)(Math.random() * 360.0D);
        this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
        this.motionY = (double)((float)(Math.random() * 0.2D) * 2.0F);
        this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    public EntityGlimmer(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.25F);
    }

    protected void entityInit()
    {
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        float f = 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        int i = super.getBrightnessForRender();
        int j = i & 255;
        int k = i >> 16 & 255;
        j = j + (int)(f * 15.0F * 16.0F);

        if (j > 240)
        {
            j = 240;
        }

        return j | k << 16;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.delayBeforeCanPickup > 0)
        {
            --this.delayBeforeCanPickup;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (!this.hasNoGravity())
        {
            this.motionY -= 0.029999999329447746D;
        }

        if (this.world.getBlockState(new BlockPos(this)).getMaterial() == Material.LAVA)
        {
            this.motionY = 0.20000000298023224D;
            this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
        }

        this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D, this.posZ);

        if (this.targetColor < this.glimmerColor - 20 + this.getEntityId() % 100)
        {
            if (this.closestPlayer == null || this.closestPlayer.getDistanceSq(this) > 64.0D)
            {
                this.closestPlayer = this.world.getClosestPlayerToEntity(this, 8.0D);
            }

            this.targetColor = this.glimmerColor;
        }

        if (this.closestPlayer != null && this.closestPlayer.isSpectator())
        {
            this.closestPlayer = null;
        }

        if (this.closestPlayer != null)
        {
            double d1 = (this.closestPlayer.posX - this.posX) / 8.0D;
            double d2 = (this.closestPlayer.posY + (double)this.closestPlayer.getEyeHeight() / 2.0D - this.posY) / 8.0D;
            double d3 = (this.closestPlayer.posZ - this.posZ) / 8.0D;
            double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 1.0D - d4;

            if (d5 > 0.0D)
            {
                d5 = d5 * d5;
                this.motionX += d1 / d4 * d5 * 0.1D;
                this.motionY += d2 / d4 * d5 * 0.1D;
                this.motionZ += d3 / d4 * d5 * 0.1D;
            }
        }

        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        float f = 0.98F;

        if (this.onGround)
        {
            BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
            net.minecraft.block.state.IBlockState underState = this.world.getBlockState(underPos);
            f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.98F;
        }

        this.motionX *= (double)f;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= (double)f;

        if (this.onGround)
        {
            this.motionY *= -0.8999999761581421D;
        }

        ++this.glimmerColor;
        ++this.orbAge;

        if (this.orbAge >= 6000)
        {
            this.setDead();
        }
    }

    /**
     * Returns if this entity is in water and will end up adding the waters velocity to the entity
     */
    public boolean handleWaterMovement()
    {
        return this.world.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.WATER, this);
    }

    /**
     * Will deal the specified amount of fire damage to the entity if the entity isn't immune to fire damage.
     */
    protected void dealFireDamage(int amount)
    {
        this.attackEntityFrom(DamageSource.IN_FIRE, (float)amount);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.world.isRemote || this.isDead) return false;
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            this.markVelocityChanged();
            this.orbHealth = (int)((float)this.orbHealth - amount);

            if (this.orbHealth <= 0)
            {
                this.setDead();
            }

            return false;
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setShort("Health", (short)this.orbHealth);
        compound.setShort("Age", (short)this.orbAge);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        this.orbHealth = compound.getShort("Health");
        this.orbAge = compound.getShort("Age");
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer entityIn)
    {
        if (!this.world.isRemote)
        {
            if (this.delayBeforeCanPickup == 0 && entityIn.xpCooldown == 0)
            {
                this.setDead();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getTextureByXP()
    {
       return 10;
    }

    public boolean canBeAttackedWithItem()
    {
        return false;
    }
}