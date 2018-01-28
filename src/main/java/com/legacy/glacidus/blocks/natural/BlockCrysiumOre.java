package com.legacy.glacidus.blocks.natural;

import java.util.Random;

import com.legacy.glacidus.items.ItemsGlacidus;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

public class BlockCrysiumOre extends Block
{

	public BlockCrysiumOre()
	{
		super(Material.ROCK);

		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setLightLevel(1F);
	}
	
	 public int quantityDroppedWithBonus(int fortune, Random random)
	    {
	        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
	    }
	
	    public int quantityDropped(Random random)
	    {
	        return 2 + random.nextInt(3);
	    }

	    public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ItemsGlacidus.crysium;
	    }

}