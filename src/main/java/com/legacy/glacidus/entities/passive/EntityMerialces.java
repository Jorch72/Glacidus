package com.legacy.glacidus.entities.passive;

import javax.annotation.Nullable;

import com.legacy.glacidus.client.sounds.GlacidusSounds;
import com.legacy.glacidus.entities.util.EntityMount;
import com.legacy.glacidus.items.ItemsGlacidus;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityMerialces extends EntityMount
{	
    private static final DataParameter<Boolean> SADDLED = EntityDataManager.<Boolean>createKey(EntityPorcali.class, DataSerializers.BOOLEAN);

    public EntityMerialces(World worldIn)
    {
        super(worldIn);
        this.setSize(1.5F, 2F);
    }
    
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ItemsGlacidus.grapes, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(SADDLED, Boolean.valueOf(false));
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Saddle", this.getSaddled());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setSaddled(compound.getBoolean("Saddle"));
    }
  
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (!this.world.isRemote)
        {
            if (this.getSaddled())
            {
                this.dropItem(ItemsGlacidus.black_saddle, 1);
            }
        }
    }

    protected SoundEvent getAmbientSound()
    {
        return GlacidusSounds.MERIALCES_SAY;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return GlacidusSounds.MERIALCES_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return GlacidusSounds.MERIALCES_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_HORSE_STEP, 0.15F, 1.0F);
    }
    
    protected float getSoundVolume()
    {
        return 0.7F;
    }
    
    @Override
	public double getMountedYOffset()
	{
		return 1.5D;
	}

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_COW;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        if (!super.processInteract(player, hand))
        {
            ItemStack itemstack = player.getHeldItem(hand);
 
            if (itemstack.getItem() == Items.NAME_TAG)
            {
                itemstack.interactWithEntity(player, this, hand);
                return true;
            }
            else if (this.getSaddled() && !this.isBeingRidden() && this.getAttackingEntity() == null)
            {
                if (!this.world.isRemote)
                {
                    player.startRiding(this);
                }

                return true;
            }
            else if (itemstack.getItem() == ItemsGlacidus.black_saddle && !this.isChild())
            {
                itemstack.interactWithEntity(player, this, hand);
                //player.startRiding(this);
                this.setSaddled(true);
                itemstack.shrink(1);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }
    
    public boolean getSaddled()
    {
        return ((Boolean)this.dataManager.get(SADDLED)).booleanValue();
    }

    public void setSaddled(boolean saddled)
    {
        if (saddled)
        {
            this.dataManager.set(SADDLED, Boolean.valueOf(true));
        }
        else
        {
            this.dataManager.set(SADDLED, Boolean.valueOf(false));
        }
    }

    public EntityMerialces createChild(EntityAgeable ageable)
    {
        return new EntityMerialces(this.world);
    }

    public float getEyeHeight()
    {
        return this.isChild() ? this.height : 1.3F;
    }
}