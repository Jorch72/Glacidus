package com.legacy.glacidus.recipes;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class LiquefierRecipes
{

	public static final LiquefierRecipes INSTANCE = new LiquefierRecipes();

    private final Map<ItemStack, ItemStack> liquefierList = Maps.<ItemStack, ItemStack>newHashMap();

    private LiquefierRecipes()
    {

    }

    public void addLiquefierRecipe(Block input, ItemStack stack)
    {
        this.addLiquefierRecipe(Item.getItemFromBlock(input), stack);
    }

    public void addLiquefierRecipe(Item input, ItemStack stack)
    {
        this.addLiquefierRecipe(new ItemStack(input, 1, 32767), stack);
    }

    public void addLiquefierRecipe(ItemStack input, ItemStack stack)
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

    public static LiquefierRecipes instance()
    {
        return INSTANCE;
    }

}