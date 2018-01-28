package com.legacy.glacidus.blocks.decoration;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUndergroundBookshelf extends Block
{
    public BlockUndergroundBookshelf()
    {
        super(Material.WOOD);
        
        this.setHardness(2F);
		this.setResistance(5F);
		this.setSoundType(SoundType.WOOD);
    }

    public int quantityDropped(Random random)
    {
        return 3;
    }
    
    @Override
	public float getEnchantPowerBonus(World world, BlockPos pos)
	{
		return 1;
	}

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.BOOK;
    }
}