package com.legacy.glacidus.util;

import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockPattern.PatternHelper;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ModUtils 
{

	private static BlockPattern bottomShape, middleShape, highMiddleShape, topShape;

	public static void registerEvent(Object object)
	{
		MinecraftForge.EVENT_BUS.register(object);
	}

    private static void getOrCreateGlacidusPortalShape()
    {
        if (bottomShape == null)
        {
        	bottomShape = FactoryBlockPattern.start().aisle("IIGII", "IAAAI", "IAAAI", "IAAAI", "IIIII").where('G', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.GLOWSTONE))).where('A', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.AIR))).where('I', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.PACKED_ICE))).build();
        }

        if (middleShape == null)
        {
        	middleShape = FactoryBlockPattern.start().aisle("AAAAA", "AAAAA", "AAAAA", "IAAAI", "IIIII").where('A', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.AIR))).where('I', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.PACKED_ICE))).build();
        }

        if (highMiddleShape == null)
        {
        	highMiddleShape = FactoryBlockPattern.start().aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "IIIII").where('A', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.AIR))).where('I', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.PACKED_ICE))).build();
        }

        if (topShape == null)
        {
        	topShape = FactoryBlockPattern.start().aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AIIIA").where('A', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.AIR))).where('I', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.PACKED_ICE))).build();
        }
    }

    public static PatternHelper matchesGlacidusPortalShape(World world, BlockPos pos)
    {
    	getOrCreateGlacidusPortalShape();

    	PatternHelper bottomPattern = bottomShape.match(world, pos);
    	PatternHelper middlePattern = middleShape.match(world, pos.up());
    	PatternHelper highMiddlePattern = highMiddleShape.match(world, pos.up(2));
    	PatternHelper topPattern = topShape.match(world, pos.up(3));

    	if (bottomPattern != null && middlePattern != null && highMiddlePattern != null && topPattern != null)
    	{
    		return bottomPattern;
    	}

    	return null;
    }

	public static BlockPos offsetPortalPosition(PatternHelper blockpattern$patternhelper) 
	{
		BlockPos pos = blockpattern$patternhelper.getFrontTopLeft();
		EnumFacing facing = blockpattern$patternhelper.getUp();

		if (facing == EnumFacing.EAST)
		{
			pos = pos.offset(facing, -3).offset(EnumFacing.NORTH, 3);
		}
		else if (facing == EnumFacing.WEST)
		{
			pos = pos.offset(facing, -1).offset(EnumFacing.NORTH, 3);
		}
		else if (facing == EnumFacing.NORTH)
		{
			pos = pos.offset(facing, -1).offset(EnumFacing.WEST, 3);
		}
		else if (facing == EnumFacing.SOUTH)
		{
			pos = pos.offset(facing, -3).offset(EnumFacing.WEST, 3);
		}

		return pos;
	}

}