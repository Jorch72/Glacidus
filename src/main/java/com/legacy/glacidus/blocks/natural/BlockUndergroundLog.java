package com.legacy.glacidus.blocks.natural;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockUndergroundLog extends BlockLog
{

	public BlockUndergroundLog()
	{
		super();

		this.setDefaultState(this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));
	}

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
    	EnumAxis enumfacing$axis = EnumAxis.Y;
        int i = meta & 12;

        if (i == 4)
        {
            enumfacing$axis = EnumAxis.X;
        }
        else if (i == 8)
        {
            enumfacing$axis = EnumAxis.Z;
        }

        return this.getDefaultState().withProperty(LOG_AXIS, enumfacing$axis);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        EnumAxis enumfacing$axis = (EnumAxis)state.getValue(LOG_AXIS);

        if (enumfacing$axis == EnumAxis.X)
        {
            i |= 4;
        }
        else if (enumfacing$axis == EnumAxis.Z)
        {
            i |= 8;
        }

        return i;
    }

	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

}