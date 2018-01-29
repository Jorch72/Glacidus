package com.legacy.glacidus.recipes;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;
import com.legacy.glacidus.blocks.BlocksGlacidus;

public class SolidifierRecipes
{

	public static final SolidifierRecipes INSTANCE = new SolidifierRecipes();

    private final Map<ItemStack, ItemStack> liquefierList = Maps.<ItemStack, ItemStack>newHashMap();

    private SolidifierRecipes()
    {
    	this.addSolidifierRecipe(BlocksGlacidus.thawed_antinatric_stone, new ItemStack(BlocksGlacidus.frozen_antinatric_stone));
    	this.addSolidifierRecipe(Items.WATER_BUCKET, new ItemStack(Blocks.ICE));
    	this.addSolidifierRecipe(Blocks.ICE, new ItemStack(Blocks.PACKED_ICE));
    	this.addSolidifierRecipe(Items.LAVA_BUCKET, new ItemStack(Blocks.OBSIDIAN));
    	
    	//this.addSolidifierRecipe(Items.WATER_BUCKET, new ItemStack(Blocks.OBSIDIAN));
    }

    public void addSolidifierRecipe(Block input, ItemStack stack)
    {
        this.addSolidifierRecipe(Item.getItemFromBlock(input), stack);
    }

    public void addSolidifierRecipe(Item input, ItemStack stack)
    {
        this.addSolidifierRecipe(new ItemStack(input, 1, 32767), stack);
    }

    public void addSolidifierRecipe(ItemStack input, ItemStack stack)
    {
        this.liquefierList.put(input, stack);
    }

    public ItemStack getSmeltingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.liquefierList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.liquefierList;
    }

    public static SolidifierRecipes instance()
    {
        return INSTANCE;
    }

}