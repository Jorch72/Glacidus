package com.legacy.glacidus.blocks.natural;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
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
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		entityIn.motionY += 0.5F;
    	entityIn.attackEntityFrom(new DamageSource("glacium_frosted"), 7.0F);
    }
	
	protected void triggerMixEffects(World worldIn, BlockPos pos)
    {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

        for (int i = 0; i < 8; ++i)
        {
            worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, d0 + Math.random(), d1 + 1.2D, d2 + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }
	
	public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.blockMaterial == GlacidusMaterial.GLACIUM)
        {
            boolean lava = false;

            boolean water = false;
            
            for (EnumFacing enumfacing : EnumFacing.values())
            {
                if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getMaterial() == Material.LAVA)
                {
                    lava = true;
                    break;
                }
                
                if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getMaterial() == Material.WATER)
                {
                    water = true;
                    break;
                }
            }

            if (lava)
            {
                Integer integer = (Integer)state.getValue(LEVEL);

                if (integer.intValue() == 0)
                {
                    worldIn.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
                    this.triggerMixEffects(worldIn, pos);
                    return true;
                }

                if (integer.intValue() <= 4)
                {
                    worldIn.setBlockState(pos, BlocksGlacidus.thawed_antinatric_stone.getDefaultState());
                    this.triggerMixEffects(worldIn, pos);
                    return true;
                }
            }
            
            if (water)
            {
                    worldIn.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
                    this.triggerMixEffects(worldIn, pos);
                    return true;              
                                            
            }
        }

        return false;
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
                
                //worldIn.playSound(d8, d4, d6, GlacidusSounds.BLOCK_GLACIUM_POP, SoundCategory.BLOCKS, 0.3F + rand.nextFloat() * 0.6F, 0.9F + rand.nextFloat() * 0.15F, false);
            }

            if (rand.nextInt(200) == 0)
            {
                //worldIn.playSound(d0, d1, d2, GlacidusSounds.BLOCK_GLACIUM_AMBIENT, SoundCategory.BLOCKS, 0.3F + rand.nextFloat() * 0.6F, 0.9F + rand.nextFloat() * 0.15F, false);
            }
            
            if (rand.nextInt(30) == 0)
            {
            	 double d8 = d0 + (double)rand.nextFloat();
                 double d4 = d1 + stateIn.getBoundingBox(worldIn, pos).maxY;
                 double d6 = d2 + (double)rand.nextFloat();
                 
            	//TODO ADD NEW PARTICLE
                worldIn.spawnParticle(EnumParticleTypes.CLOUD, d8, d4, d6, 0.0D, 0.0D, 0.0D);
            
            }
        }
    }
    
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.checkForMixing(worldIn, pos, state);
        
        if (pos.getY() == 27)
		{
			worldIn.setBlockToAir(pos);
			//worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);
		}
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.checkForMixing(worldIn, pos, state);
        if (pos.getY() == 27)
		{
			worldIn.setBlockToAir(pos);
			//worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);
		}
    }
    public int tickRate(World worldIn)
    {
    	return 3;
    }
    

}