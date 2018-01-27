package com.legacy.glacidus.blocks.natural;

import com.legacy.glacidus.ModConfig;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAntinatricStone extends Block 
{

	public BlockAntinatricStone() 
	{
		super(Material.ROCK);

		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}

    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type)
    {
    	if (world instanceof World)
    	{
    		World worldInstance = (World) world;

    		if (worldInstance.provider.getDimension() == ModConfig.dimensionID)
    		{
    			if (pos.getY() >= 80)
    			{
    				
    			}
    		}
    	}

        return super.canCreatureSpawn(state, world, pos, type);
    }

}