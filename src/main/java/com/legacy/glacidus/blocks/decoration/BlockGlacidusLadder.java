package com.legacy.glacidus.blocks.decoration;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;

public class BlockGlacidusLadder extends BlockLadder
{
    public BlockGlacidusLadder()
    {
        super();
        this.setSoundType(SoundType.WOOD);
        this.setHardness(0.4f);
        this.disableStats();
    }
}
