package com.legacy.glacidus.items.tools.axes;

import com.legacy.glacidus.items.tools.EukeiteAbility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEukeiteAxe extends ItemAxe
{

	public ItemEukeiteAxe() 
	{
		super(ToolMaterial.IRON, ToolMaterial.IRON.getAttackDamage(), -3.1F);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		return EukeiteAbility.echolocate(world, player, hand, 50);
	}

}