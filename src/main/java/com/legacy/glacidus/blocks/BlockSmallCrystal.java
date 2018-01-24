package com.legacy.glacidus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockSmallCrystal extends Block 
{

	public BlockSmallCrystal() 
	{
		super(Material.IRON);

		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}

	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    public boolean isNormalCube(IBlockState state)
    {
    	return false;
    }
   
}