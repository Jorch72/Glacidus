package com.legacy.glacidus.blocks.natural;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlacidusSapling extends BlockBush
{
    public BlockGlacidusSapling()
    {
        super();

        this.setSoundType(SoundType.PLANT);
    }

    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == BlocksGlacidus.lumicia_grass || state.getBlock() == BlocksGlacidus.lumicia_grass;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

}