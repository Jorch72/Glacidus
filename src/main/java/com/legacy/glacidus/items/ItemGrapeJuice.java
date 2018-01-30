package com.legacy.glacidus.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemGrapeJuice extends Item
{
	 public ItemGrapeJuice()
	    {
	        this.setMaxStackSize(1);
	        this.setCreativeTab(CreativeTabs.BREWING);
	    }
	 
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	    {
	        EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;

	        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
	        {
	            stack.shrink(1);
	        }

	        if (entityplayer instanceof EntityPlayerMP)
	        {
	            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
	            
	            entityplayer.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 1, false, false));
	            entityplayer.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1200, 0, false, false));
	        }	   

	        if (entityplayer != null)
	        {
	            entityplayer.addStat(StatList.getObjectUseStats(this));
	        }

	        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
	        {
	            if (stack.isEmpty())
	            {
	                return new ItemStack(Items.GLASS_BOTTLE);
	            }

	            if (entityplayer != null)
	            {
	                entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
	            }
	        }

	        return stack;
	    }

	    public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 32;
	    }

	    public EnumAction getItemUseAction(ItemStack stack)
	    {
	        return EnumAction.DRINK;
	    }

	    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        playerIn.setActiveHand(handIn);
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	    }
}
