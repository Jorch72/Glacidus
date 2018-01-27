package com.legacy.glacidus.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import com.legacy.glacidus.blocks.decoration.BlockUndergroundPlanks;
import com.legacy.glacidus.blocks.natural.BlockAntinatricStone;
import com.legacy.glacidus.blocks.natural.BlockCrysiumOre;
import com.legacy.glacidus.blocks.natural.BlockDeadLumicia;
import com.legacy.glacidus.blocks.natural.BlockEukeiteOre;
import com.legacy.glacidus.blocks.natural.BlockGlaciditeOre;
import com.legacy.glacidus.blocks.natural.BlockGlacidusFlower;
import com.legacy.glacidus.blocks.natural.BlockGlaciumStatic;
import com.legacy.glacidus.blocks.natural.BlockLumiciaDirt;
import com.legacy.glacidus.blocks.natural.BlockLumiciaGrass;
import com.legacy.glacidus.blocks.natural.BlockLumiciaTallGrass;
import com.legacy.glacidus.blocks.natural.BlockLumiciaVine;
import com.legacy.glacidus.blocks.natural.BlockUndergroundLeaves;
import com.legacy.glacidus.blocks.natural.BlockUndergroundLog;
import com.legacy.glacidus.creativetab.GlacidusCreativeTabs;
import com.legacy.glacidus.items.block.ItemGlacidusDoor;
import com.legacy.glacidus.util.ModInfo;

public class BlocksGlacidus 
{

	private static IForgeRegistry<Block> iBlockRegistry;

	private static IForgeRegistry<Item> iItemRegistry;

	@ObjectHolder(ModInfo.MOD_ID + ":small_crystal")
	public static Block small_crystal;

	@ObjectHolder(ModInfo.MOD_ID + ":crysial_flower")
	public static Block crysial_flower;

	@ObjectHolder(ModInfo.MOD_ID + ":pulphorus_flower")
	public static Block pulphorus_flower;

	@ObjectHolder(ModInfo.MOD_ID + ":solegia_flower")
	public static Block solegia_flower;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_tallgrass")
	public static Block lumicia_tallgrass;

	@ObjectHolder(ModInfo.MOD_ID + ":dead_lumicia")
	public static Block dead_lumicia;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidus_portal")
	public static Block glacidus_portal;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_grass")
	public static Block lumicia_grass;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_dirt")
	public static Block lumicia_dirt;

	@ObjectHolder(ModInfo.MOD_ID + ":frozen_antinatric_stone")
	public static Block frozen_antinatric_stone;

	@ObjectHolder(ModInfo.MOD_ID + ":thawed_antinatric_stone")
	public static Block thawed_antinatric_stone;

	@ObjectHolder(ModInfo.MOD_ID + ":glacium")
	public static Block glacium;

	@ObjectHolder(ModInfo.MOD_ID + ":underground_log")
	public static Block underground_log;

	@ObjectHolder(ModInfo.MOD_ID + ":underground_planks")
	public static Block underground_planks;

	@ObjectHolder(ModInfo.MOD_ID + ":underground_leaves")
	public static Block underground_leaves;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_vine")
	public static Block lumicia_vine;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_grape_vine")
	public static Block lumicia_grape_vine;

	@ObjectHolder(ModInfo.MOD_ID + ":eukeite_ore")
	public static Block eukeite_ore;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidite_ore")
	public static Block glacidite_ore;

	@ObjectHolder(ModInfo.MOD_ID + ":crysium_ore")
	public static Block crysium_ore;

	@ObjectHolder(ModInfo.MOD_ID + ":underground_door")
	public static Block underground_door;

    public static final Fluid GLACIUM = new Fluid("glacium", ModInfo.locate("blocks/glacium_still"), ModInfo.locate("blocks/glacium_flow"))
    {
        @Override
        public String getLocalizedName(FluidStack fs) 
        {
            return new TextComponentTranslation("tile.glacium.name").getFormattedText();
        }
    }.setLuminosity(10).setDensity(5000).setViscosity(6000).setTemperature(-1500).setUnlocalizedName(ModInfo.locate("glacium").toString());

	public static void initialization()
	{
		if (!readyToInitialize())
		{
			return;
		}

		FluidRegistry.registerFluid(GLACIUM);

		small_crystal = register("small_crystal", new BlockSmallCrystal());

		crysial_flower = register("crysial_flower", new BlockGlacidusFlower());
		pulphorus_flower = register("pulphorus_flower", new BlockGlacidusFlower());
		solegia_flower = register("solegia_flower", new BlockGlacidusFlower());
		lumicia_tallgrass = register("lumicia_tallgrass", new BlockLumiciaTallGrass());
		dead_lumicia = register("dead_lumicia", new BlockDeadLumicia());

		glacidus_portal  = register("glacidus_portal", new BlockGlacidusPortal());

		lumicia_grass = register("lumicia_grass", new BlockLumiciaGrass());
		lumicia_dirt = register("lumicia_dirt", new BlockLumiciaDirt());
		frozen_antinatric_stone = register("frozen_antinatric_stone", new BlockAntinatricStone());
		thawed_antinatric_stone = register("thawed_antinatric_stone", new BlockAntinatricStone());

		glacium = register("glacium", new BlockGlaciumStatic());

		underground_log = register("underground_log", new BlockUndergroundLog());
		underground_planks = register("underground_planks", new BlockUndergroundPlanks());
		underground_leaves = register("underground_leaves", new BlockUndergroundLeaves());

		lumicia_vine = register("lumicia_vine", new BlockLumiciaVine());
		lumicia_grape_vine = register("lumicia_grape_vine", new BlockLumiciaVine());

		glacidite_ore = register("glacidite_ore", new BlockGlaciditeOre());
		eukeite_ore = register("eukeite_ore", new BlockEukeiteOre());
		crysium_ore = register("crysium_ore", new BlockCrysiumOre());

		underground_door = register("underground_door", new BlockUndergroundDoor(), ItemGlacidusDoor.class);
	}

	private static boolean readyToInitialize()
	{
		return iBlockRegistry != null && iItemRegistry != null;
	}

	private static Block register(String unlocalizedName, Block block)
	{
		return register(unlocalizedName, block, ItemBlock.class);
	}

	private static Block register(String unlocalizedName, Block block, Class<? extends Item> itemClass)
	{
		Item itemBlock = null;

		try 
		{
			itemBlock = itemClass.getConstructor(Block.class).newInstance(block);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		block.setCreativeTab(GlacidusCreativeTabs.BLOCKS);
		block.setUnlocalizedName(unlocalizedName);

		block.setRegistryName(ModInfo.locate(unlocalizedName));
		itemBlock.setRegistryName(ModInfo.locate(unlocalizedName));

		iBlockRegistry.register(block);
		iItemRegistry.register(itemBlock);

		return block;
	}

	public static void setBlockRegistry(IForgeRegistry<Block> iBlockRegistry)
	{
		BlocksGlacidus.iBlockRegistry = iBlockRegistry;
	}

	public static void setItemRegistry(IForgeRegistry<Item> iItemRegistry)
	{
		BlocksGlacidus.iItemRegistry = iItemRegistry;
	}

}