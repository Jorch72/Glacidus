package com.legacy.glacidus.blocks.natural;

import java.util.Random;

import javax.annotation.Nullable;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.items.ItemsGlacidus;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLumiciaVine extends BlockVine
{

    public BlockLumiciaVine()
    {
    	super();

    	this.setHardness(0.2F);
    	this.setSoundType(SoundType.PLANT);
    }

	@Override
    @SuppressWarnings("deprecation")
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	super.updateTick(worldIn, pos, state, rand);

    	if (this == BlocksGlacidus.lumicia_vine && rand.nextInt(10) == 0)
    	{
    		worldIn.setBlockState(pos, BlocksGlacidus.lumicia_grape_vine.getStateFromMeta(this.getMetaFromState(state)));
    	}
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if (this == BlocksGlacidus.lumicia_grape_vine)
    	{
    		spawnAsEntity(worldIn, pos, new ItemStack(ItemsGlacidus.grapes));
    		worldIn.setBlockState(pos, BlocksGlacidus.lumicia_vine.getStateFromMeta(this.getMetaFromState(state)));
    	}

    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean canAttachTo(World p_193395_1_, BlockPos p_193395_2_, EnumFacing p_193395_3_)
    {
        Block block = p_193395_1_.getBlockState(p_193395_2_.up()).getBlock();
        return this.isAcceptableNeighbor(p_193395_1_, p_193395_2_.offset(p_193395_3_.getOpposite()), p_193395_3_) && (block == Blocks.AIR || block == BlocksGlacidus.lumicia_vine || block == BlocksGlacidus.lumicia_grape_vine || this.isAcceptableNeighbor(p_193395_1_, p_193395_2_.up(), EnumFacing.UP));
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote)
        {
        	if (stack.getItem() == Items.SHEARS)
        	{
                player.addStat(StatList.getBlockStats(this));
                spawnAsEntity(worldIn, pos, new ItemStack(BlocksGlacidus.lumicia_vine, 1, 0));
        	}

        	if (worldIn.getBlockState(pos).getBlock() == BlocksGlacidus.lumicia_grape_vine)
        	{
            	spawnAsEntity(worldIn, pos, new ItemStack(ItemsGlacidus.grapes));
        	}
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    private boolean isAcceptableNeighbor(World p_193396_1_, BlockPos p_193396_2_, EnumFacing p_193396_3_)
    {
        IBlockState iblockstate = p_193396_1_.getBlockState(p_193396_2_);
        return iblockstate.getBlockFaceShape(p_193396_1_, p_193396_2_, p_193396_3_) == BlockFaceShape.SOLID && !isExceptBlockForAttaching(iblockstate.getBlock());
    }

}