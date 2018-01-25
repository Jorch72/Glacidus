package com.legacy.glacidus.entities;

import java.util.Random;

import com.legacy.glacidus.blocks.BlocksGlacidus;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityGlacidusAnimal extends EntityAnimal
{
    protected Block spawnableBlock = BlocksGlacidus.lumicia_grass;
    
    Random random;

    public EntityGlacidusAnimal(World worldIn)
    {
        super(worldIn);
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        return this.world.getBlockState(blockpos.down()).getBlock() == this.spawnableBlock && super.getCanSpawnHere();
    }

    protected boolean canDespawn()
    {
        return false;
    }

    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == Items.WHEAT;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();

	   for (int i = 0; i < 1; ++i)
       {
           double d0 = this.rand.nextGaussian() * 0.02D;
           double d1 = this.rand.nextGaussian() * 0.02D;
           double d2 = this.rand.nextGaussian() * 0.02D;
           this.world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
       }
    }
}
    