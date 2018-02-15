package com.legacy.glacidus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import com.legacy.glacidus.blocks.decoration.BlockGlacidusSlab;
import com.legacy.glacidus.blocks.decoration.BlockGlacidusStairs;
import com.legacy.glacidus.blocks.decoration.BlockUndergroundBookshelf;
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
import com.legacy.glacidus.items.block.ItemGlacidusSlab;
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

	@ObjectHolder(ModInfo.MOD_ID + ":auransucus_flower")
	public static Block auransucus_flower;

	@ObjectHolder(ModInfo.MOD_ID + ":lumicia_tallgrass")
	public static Block lumicia_tallgrass;

	@ObjectHolder(ModInfo.MOD_ID + ":dead_lumicia")
	public static Block dead_lumicia;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidus_portal")
	public static Block glacidus_portal;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidus_portal_frame")
	public static Block glacidus_portal_frame;

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
	
	@ObjectHolder(ModInfo.MOD_ID + ":underground_bookshelf")
	public static Block underground_bookshelf;

	@ObjectHolder(ModInfo.MOD_ID + ":underground_door")
	public static Block underground_door;
	
	@ObjectHolder(ModInfo.MOD_ID + ":underground_slab")
	public static Block underground_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":underground_double_slab")
	public static Block underground_double_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":underground_stairs")
	public static Block underground_stairs;
	
	@ObjectHolder(ModInfo.MOD_ID + ":frozen_antinatric_slab")
	public static Block frozen_antinatric_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":frozen_antinatric_double_slab")
	public static Block frozen_antinatric_double_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":frozen_antinatric_stairs")
	public static Block frozen_antinatric_stairs;
	
	@ObjectHolder(ModInfo.MOD_ID + ":thawed_antinatric_slab")
	public static Block thawed_antinatric_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":thawed_antinatric_double_slab")
	public static Block thawed_antinatric_double_slab;
	
	@ObjectHolder(ModInfo.MOD_ID + ":thawed_antinatric_stairs")
	public static Block thawed_antinatric_stairs;

	@ObjectHolder(ModInfo.MOD_ID + ":glacidus_booster")
	public static Block glacidus_booster;

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
		auransucus_flower = register("auransucus_flower", new BlockGlacidusFlower());
		solegia_flower = register("solegia_flower", new BlockGlacidusFlower());
		lumicia_tallgrass = register("lumicia_tallgrass", new BlockLumiciaTallGrass());
		dead_lumicia = register("dead_lumicia", new BlockDeadLumicia());

		glacidus_portal  = register("glacidus_portal", new BlockGlacidusPortal());
		glacidus_portal_frame = register("glacidus_portal_frame", new BlockGlacidusPortalFrame());

		lumicia_grass = register("lumicia_grass", new BlockLumiciaGrass());
		lumicia_dirt = register("lumicia_dirt", new BlockLumiciaDirt());
		frozen_antinatric_stone = register("frozen_antinatric_stone", new BlockAntinatricStone());
		thawed_antinatric_stone = register("thawed_antinatric_stone", new BlockAntinatricStone());

		glacium = register("glacium", new BlockGlaciumStatic().setCreativeTab(null));

		underground_log = register("underground_log", new BlockUndergroundLog());
		underground_planks = register("underground_planks", new BlockUndergroundPlanks());
		underground_leaves = register("underground_leaves", new BlockUndergroundLeaves());

		lumicia_vine = register("lumicia_vine", new BlockLumiciaVine());
		lumicia_grape_vine = register("lumicia_grape_vine", new BlockLumiciaVine());

		glacidite_ore = register("glacidite_ore", new BlockGlaciditeOre());
		eukeite_ore = register("eukeite_ore", new BlockEukeiteOre());
		crysium_ore = register("crysium_ore", new BlockCrysiumOre());
		
		underground_bookshelf = register("underground_bookshelf", new BlockUndergroundBookshelf());
		
		underground_stairs = register("underground_stairs", new BlockGlacidusStairs(underground_planks.getDefaultState()));

		underground_door = register("underground_door", new BlockUndergroundDoor(), ItemGlacidusDoor.class);
		
		underground_double_slab = register("underground_double_slab", new BlockGlacidusSlab("underground_double_slab", true, Material.WOOD).setHardness(2.0F).setResistance(5.0F)).setCreativeTab(null);
		underground_slab = registerSlab("underground_slab", new BlockGlacidusSlab("underground_slab", false, Material.WOOD).setHardness(2.0F).setResistance(5.0F), underground_double_slab);

		glacidus_booster = register("glacidus_booster", new BlockGlacidusBooster());
		//solidifier = register("solidifier", new BlockSolidifier());

		frozen_antinatric_double_slab = register("frozen_antinatric_double_slab", new BlockGlacidusSlab("frozen_antinatric_double_slab", true, Material.ROCK).setHardness(1.5F).setResistance(10.0F)).setCreativeTab(null);
		frozen_antinatric_slab = registerSlab("frozen_antinatric_slab", new BlockGlacidusSlab("frozen_antinatric_slab", false, Material.ROCK).setHardness(1.5F).setResistance(10.0F), frozen_antinatric_double_slab);
		frozen_antinatric_stairs = register("frozen_antinatric_stairs", new BlockGlacidusStairs(frozen_antinatric_stone.getDefaultState()));
		
		thawed_antinatric_double_slab = register("thawed_antinatric_double_slab", new BlockGlacidusSlab("thawed_antinatric_double_slab", true, Material.ROCK).setHardness(1.5F).setResistance(10.0F)).setCreativeTab(null);
		thawed_antinatric_slab = registerSlab("thawed_antinatric_slab", new BlockGlacidusSlab("thawed_antinatric_slab", false, Material.ROCK).setHardness(1.5F).setResistance(10.0F), thawed_antinatric_double_slab);
		thawed_antinatric_stairs = register("thawed_antinatric_stairs", new BlockGlacidusStairs(thawed_antinatric_stone.getDefaultState()));

		FurnaceRecipes.instance().addSmeltingRecipeForBlock(frozen_antinatric_stone, new ItemStack(thawed_antinatric_stone), 0.1F);
		
		crysium_ore.setHarvestLevel("pickaxe", 0);
		eukeite_ore.setHarvestLevel("pickaxe", 1);
		glacidite_ore.setHarvestLevel("pickaxe", 2);
	}

	private static boolean readyToInitialize()
	{
		return iBlockRegistry != null && iItemRegistry != null;
	}

	private static Block register(String unlocalizedName, Block block)
	{
		return register(unlocalizedName, block, ItemBlock.class);
	}
	
	public static Block registerSlab(String unlocalizedName, Block slab1, Block slab2)
	{
		slab1.setCreativeTab(GlacidusCreativeTabs.BLOCKS);

		iBlockRegistry.register(slab1.setRegistryName(ModInfo.locate(unlocalizedName)));
		iItemRegistry.register(new ItemGlacidusSlab(slab1, (BlockSlab) slab1, (BlockSlab) slab2).setRegistryName(ModInfo.locate(unlocalizedName)));
		
		return slab1;
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