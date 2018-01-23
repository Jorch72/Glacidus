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

            for (int j = 0; j < 3; ++j)
            {
                for (int k = 0; k < 3; ++k)
                {
                	event.getWorld().setBlockState(blockpos.add(j, 0, k), BlocksGlacidus.glacidus_portal.getDefaultState(), 2);
                }
            }
        }
	}

}