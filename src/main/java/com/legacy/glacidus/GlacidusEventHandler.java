package com.legacy.glacidus;

import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.util.ModUtils;

public class GlacidusEventHandler 
{

	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event)
	{

	}

	@SubscribeEvent
	public void onBreakBlock(BreakEvent event)
	{
		if (event.getState().getBlock() != Blocks.GLOWSTONE)
		{
			return;
		}

        BlockPattern.PatternHelper blockpattern$patternhelper = ModUtils.matchesGlacidusPortalShape(event.getWorld(), event.getPos());

        if (blockpattern$patternhelper != null)
        {
            BlockPos blockpos = ModUtils.offsetPortalPosition(blockpattern$patternhelper);

            for (int j = -1; j < 4; ++j)
            {
            	for (int y = 0; y < 4; ++y)
            	{
                    for (int k = -1; k < 4; ++k)
                    {
                    	BlockPos pos = blockpos.add(j, y, k);

                    	if ((j <= 2 && j >= 0) && (k <= 2 && k >= 0) && y == 0)
                    	{
                        	event.getWorld().setBlockState(pos, BlocksGlacidus.glacidus_portal.getDefaultState(), 2);
                    	}

                    	if (event.getWorld().getBlockState(pos).getBlock() == Blocks.PACKED_ICE)
                    	{
                    		event.getWorld().setBlockState(pos, BlocksGlacidus.glacidus_portal_frame.getDefaultState(), 2);
                    	}
                    }
            	}
            }

            event.setCanceled(true);
            return;
        }

        BlockPattern.PatternHelper blockpattern$patternhelper1 = ModUtils.matchesGlacidusSolidPortalShape(event.getWorld(), event.getPos());

        if (blockpattern$patternhelper1 != null)
        {
            BlockPos blockpos = ModUtils.offsetPortalPosition(blockpattern$patternhelper1);

            for (int j = -1; j < 4; ++j)
            {
            	for (int y = 0; y < 4; ++y)
            	{
                    for (int k = -1; k < 4; ++k)
                    {
                    	BlockPos pos = blockpos.add(j, y, k);

                    	if ((j <= 2 && j >= 0) && (k <= 2 && k >= 0) && y == 0)
                    	{
                        	event.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    	}

                    	if (event.getWorld().getBlockState(pos).getBlock() == BlocksGlacidus.glacidus_portal_frame)
                    	{
                    		event.getWorld().setBlockState(pos, Blocks.PACKED_ICE.getDefaultState(), 2);
                    	}
                    }
            	}
            }

            event.setCanceled(true);
            return;
        }
	}

}