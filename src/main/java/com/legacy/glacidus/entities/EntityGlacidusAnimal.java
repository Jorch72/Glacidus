package com.legacy.glacidus.entities;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.items.ItemsGlacidus;

public abstract class EntityGlacidusAnimal extends EntityAnimal
{

    public EntityGlacidusAnimal(World worldIn)
    {
        super(worldIn);
    }

    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);

        System.out.println(blockpos.getY());
        return blockpos.getY() <= 71 && blockpos.getY() >= 34 && this.world.getBlockState(blockpos.down()).getBlock() == BlocksGlacidus.lumicia_grass && super.getCanSpawnHere();
    }

    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == ItemsGlacidus.grapes;
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
    