package com.legacy.glacidus.blocks.natural;

import javax.annotation.Nullable;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUndergroundLeaves extends BlockLeaves
{

    public static final PropertyBool GLOWING = PropertyBool.create("glowing");

    public BlockUndergroundLeaves()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(GLOWING, Boolean.valueOf(false)).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
    	return true;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
    	return BlockRenderLayer.CUTOUT_MIPPED;
    }

	@Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
        if (worldIn.rand.nextInt(chance) == 0)
        {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.APPLE));
        }
    }

	@Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this, 1, 0));
        items.add(new ItemStack(this, 1, 1));
    }

	@Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(GLOWING).booleanValue() ? 1 : 0);
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(GLOWING, Boolean.valueOf(meta == 0)).withProperty(DECAYABLE, Boolean.valueOf((meta & 2) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 4) > 0));
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((state.getValue(GLOWING).booleanValue()) ? 1 : 0);

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 2;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 4;
        }

        return i;
    }

	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {GLOWING, CHECK_DECAY, DECAYABLE});
    }

	@Override
    public int damageDropped(IBlockState state)
    {
    	return 0;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(GLOWING).booleanValue() ? 1 : 0));
    }

	@Override
	public EnumType getWoodType(int meta) 
	{
		return EnumType.OAK;
	}

}