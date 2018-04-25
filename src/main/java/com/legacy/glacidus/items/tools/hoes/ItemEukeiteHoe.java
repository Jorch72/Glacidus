package com.legacy.glacidus.items.tools.hoes;

import com.legacy.glacidus.items.tools.EukeiteAbility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEukeiteHoe extends ItemHoe
{

	public ItemEukeiteHoe()
	{
		super(ToolMaterial.IRON);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		return EukeiteAbility.echolocate(world, player, hand, 50);
	}

}