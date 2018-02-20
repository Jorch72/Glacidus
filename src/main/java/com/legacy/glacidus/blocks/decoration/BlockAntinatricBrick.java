package com.legacy.glacidus.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAntinatricBrick extends Block {

    public BlockAntinatricBrick() {

        super(Material.ROCK);

        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.STONE);


    }
}
