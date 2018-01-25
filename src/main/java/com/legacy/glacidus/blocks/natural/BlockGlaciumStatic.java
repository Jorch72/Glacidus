package com.legacy.glacidus.blocks.natural;

import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.blocks.material.GlacidusMaterial;
import com.legacy.glacidus.client.sounds.GlacidusSounds;

public class BlockGlaciumStatic extends BlockFluidClassic
{

	public BlockGlaciumStatic()
	{
		super(BlocksGlacidus.GLACIUM, GlacidusMaterial.GLACIUM);
	}

	@Override
    public int getLightValue(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos)
    {
    	return 0;
    }

	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		entityIn.motionY += 0.5F;
    	entityIn.attackEntityFrom(new DamageSource("glacium_frosted"), 7.0F);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();

        if (worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && !worldIn.getBlockState(pos.up()).isOpaqueCube())
        {
            if (rand.nextInt(100) == 0)
            {
                double d8 = d0 + (double)rand.nextFloat();
                double d4 = d1 + stateIn.getBoundingBox(worldIn, pos).maxY;
                double d6 = d2 + (double)rand.nextFloat();

                //worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
                worldIn.playSound(d8, d4, d6, GlacidusSounds.BLOCK_GLACIUM_POP, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }

            if (rand.nextInt(200) == 0)
            {
                worldIn.playSound(d0, d1, d2, GlacidusSounds.BLOCK_GLACIUM_AMBIENT, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }
        }
    }

}