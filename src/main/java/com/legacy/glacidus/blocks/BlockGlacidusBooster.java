package com.legacy.glacidus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlacidusBooster extends Block 
{

	public BlockGlacidusBooster() 
	{
		super(Material.ROCK);
	}

	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        double d1 = entityIn.motionX;
        double d2 = entityIn.motionY;
        double d3 = entityIn.motionZ;

        entityIn.motionY += 10.0F;

        if (entityIn instanceof EntityPlayerMP && entityIn.velocityChanged)
        {
            ((EntityPlayerMP)entityIn).connection.sendPacket(new SPacketEntityVelocity(entityIn));
            entityIn.velocityChanged = false;
            entityIn.motionX = d1;
            entityIn.motionY = d2;
            entityIn.motionZ = d3;
        }

    }

	@Override
    @SuppressWarnings("deprecation")
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.getBlockState(pos.down()).isTopSolid())
        {
            worldIn.setBlockToAir(pos);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @Override
    public boolean isCollidable()
    {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
    	return super.canPlaceBlockAt(worldIn, pos) && worldIn.getBlockState(pos.down()).getBlockFaceShape(worldIn, pos, EnumFacing.UP) == BlockFaceShape.SOLID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

}