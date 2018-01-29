package com.legacy.glacidus.blocks.container;

import com.legacy.glacidus.tiles.TileEntitySolidifier;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockSolidifier extends BlockContainer
{

	public BlockSolidifier() 
	{
		super(Material.ROCK);
	}

	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntitySolidifier();
	}

}