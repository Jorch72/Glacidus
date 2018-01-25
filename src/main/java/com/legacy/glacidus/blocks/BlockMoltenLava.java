package com.legacy.glacidus.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMoltenLava extends BlockFluidClassic
{

	public BlockMoltenLava()
	{
		super(BlocksGlacidus.MOLTEN_LAVA, Material.LAVA);
	}

	@Override
    public int getLightValue(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos)
    {
    	return 0;
    }

}