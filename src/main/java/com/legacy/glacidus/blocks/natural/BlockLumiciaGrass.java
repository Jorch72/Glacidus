package com.legacy.glacidus.blocks.natural;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.legacy.glacidus.blocks.BlocksGlacidus;

public class BlockLumiciaGrass extends Block
{

	public BlockLumiciaGrass() 
	{
		super(Material.GRASS);

		this.setHardness(0.6F);
		this.setTickRandomly(true);
		this.setSoundType(SoundType.PLANT);
	}

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, BlocksGlacidus.lumicia_dirt.getDefaultState());
            }
            else
            {
                for (int i = 0; i < 4; ++i)
                {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                    if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                    {
                        return;
                    }

                    IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                    if (iblockstate1.getBlock() == BlocksGlacidus.lumicia_dirt)
                    {
                        worldIn.setBlockState(blockpos, BlocksGlacidus.lumicia_grass.getDefaultState());
                    }
                }
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlocksGlacidus.lumicia_dirt.getItemDropped(state, rand, fortune);
    }

}