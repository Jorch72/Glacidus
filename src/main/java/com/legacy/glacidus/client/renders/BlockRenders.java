package com.legacy.glacidus.client.renders;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.legacy.glacidus.blocks.BlocksGlacidus;
import com.legacy.glacidus.client.renders.tiles.GlacidusPortalRenderer;
import com.legacy.glacidus.tiles.TileEntityGlacidusPortal;
import com.legacy.glacidus.util.ModInfo;

public class BlockRenders 
{

	@SubscribeEvent
	public void onModelRegisterEvent(ModelRegistryEvent event)
	{
		registerBlockWithStateMapper(BlocksGlacidus.underground_leaves, (new StateMap.Builder()).ignore(BlockLeaves.CHECK_DECAY).ignore(BlockLeaves.DECAYABLE).build());
		registerBlockWithStateMapper(BlocksGlacidus.underground_door, (new StateMap.Builder()).ignore(BlockDoor.POWERED).build());

		register(BlocksGlacidus.small_crystal, "small_crystal");
		register(BlocksGlacidus.crysial_flower, "crysial_flower");
		register(BlocksGlacidus.pulphorus_flower, "pulphorus_flower");
		register(BlocksGlacidus.solegia_flower, "solegia_flower");
		register(BlocksGlacidus.lumicia_tallgrass, "lumicia_tallgrass");
		register(BlocksGlacidus.dead_lumicia, "dead_lumicia");
		register(BlocksGlacidus.lumicia_grass, "lumicia_grass");
		register(BlocksGlacidus.lumicia_dirt, "lumicia_dirt");
		register(BlocksGlacidus.frozen_antinatric_stone, "frozen_antinatric_stone");
		register(BlocksGlacidus.thawed_antinatric_stone, "thawed_antinatric_stone");
		register(BlocksGlacidus.underground_leaves, "underground_leaves");
		register(BlocksGlacidus.underground_log, "underground_log");
		register(BlocksGlacidus.underground_planks, "underground_planks");
		register(BlocksGlacidus.glacidite_ore, "glacidite_ore");
		register(BlocksGlacidus.eukeite_ore, "eukeite_ore");
		register(BlocksGlacidus.crysium_ore, "crysium_ore");
		register(BlocksGlacidus.underground_door, "underground_door");


		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlacidusPortal.class, new GlacidusPortalRenderer());
	}

	private static void registerBlockWithStateMapper(Block block, IStateMapper mapper)
	{
		ModelLoader.setCustomStateMapper(block, mapper);

		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(block), new ItemMeshDefinition() 
		{
			@Override
			@SuppressWarnings("deprecation")
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				Block block = Block.getBlockFromItem(stack.getItem());

				return Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().getBlockStateMapper().getVariants(block).get(block.getStateFromMeta(stack.getMetadata()));
			}
		});
	}

	private static void register(Block block, String model)
	{
		register(block, 0, model);
	}

	private static void register(Block block, int meta, String model)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(ModInfo.MOD_ID + ":" + model, "inventory"));
	}

	private static void registerMetadata(Block block, ResourceLocation... model)
	{
		ModelLoader.registerItemVariants(Item.getItemFromBlock(block), model);
	}

}