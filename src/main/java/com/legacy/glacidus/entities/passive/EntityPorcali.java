package com.legacy.glacidus.entities.passive;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
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
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import com.legacy.glacidus.client.sounds.GlacidusSounds;
import com.legacy.glacidus.entities.util.EntityMount;
import com.legacy.glacidus.items.ItemsGlacidus;
import com.legacy.glacidus.loottables.GlacidusLootTables;

public class EntityPorcali extends EntityMount
{
    private static final DataParameter<Boolean> SADDLED = EntityDataManager.<Boolean>createKey(EntityPorcali.class, DataSerializers.BOOLEAN);
    
    public EntityPorcali(World worldIn)
    {
        super(worldIn);
        this.setSize(1.4F, 1.4F);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, ItemsGlacidus.grapes, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }
    
    @Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();

		if (this.getAttackingEntity() != null && world.getDifficulty() != EnumDifficulty.PEACEFUL)
		{
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.7F, true));
			this.updateAITasks();
		}
		else
		{
			this.tasks.removeTask(new EntityAIAttackMelee(this, 1.7F, true));
			//this.tasks.addTask(3, new EntityAIPanic(this, 1.25D));
			this.updateAITasks();
		}
		this.setAttackTarget(this.getAttackingEntity());
		
		
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
    
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setSaddled(compound.getBoolean("Saddle"));
    }

    protected SoundEvent getAmbientSound()
    {
        return GlacidusSounds.PORCALI_SAY;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return GlacidusSounds.PORCALI_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return GlacidusSounds.PORCALI_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
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
                this.setSaddled(true);
                itemstack.shrink(1);
                //player.startRiding(this);
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

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return GlacidusLootTables.porcali;
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
    
    @Override
	public double getMountedYOffset()
	{
		return 0.85D;
	}

    public EntityPorcali createChild(EntityAgeable ageable)
    {
        return new EntityPorcali(this.world);
    }
    
    @Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0F);
		return true;
	}
    
}