package com.pengu.lostthaumaturgy.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.pengu.lostthaumaturgy.items.ItemMultiMaterial.EnumMultiMaterialType;

public class RecipesLT
{
	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRUCIBLE, "v", "c", "f", 'v', "crystalVis", 'c', Items.CAULDRON, 'f', Blocks.FURNACE));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.INFUSER, "iti", "ici", "sss", 'i', "ingotIron", 't', new ItemStack(Blocks.STONE_SLAB), 'c', "crystalVis", 's', "stone"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.VIS_TANK, "wgw", "g g", "wgw", 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack(), 'g', "paneGlass"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksLT.CONDUIT, 8), "wgw", "grg", "wgw", 'w', "plankWood", 'g', "paneGlass", 'r', "dustRedstone"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.VIS_VALVE, "clc", 'c', BlocksLT.CONDUIT, 'l', Blocks.LEVER));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.BELLOWS, "ww ", "lvi", "ww ", 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack(), 'v', EnumMultiMaterialType.VAPOROUS_CRYSTAL.stack(), 'l', "leather", 'i', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.VIS_PUMP, "waw", "wcw", "wbw", 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack(), 'a', EnumMultiMaterialType.AQUEOUS_CRYSTAL.stack(), 'b', BlocksLT.BELLOWS, 'c', BlocksLT.CONDUIT));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_VAPOROUS, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.VAPOROUS_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_AQUEOUS, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.AQUEOUS_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_EARTHEN, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.EARTHEN_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_FIERY, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.FIERY_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_VIS, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.VIS_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_TAINTED, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.TAINTED_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTAL_ORE_DEPLETED, "ccc", "ccc", "ccc", 'c', EnumMultiMaterialType.DEPLETED_CRYSTAL.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.VIS_FILTER, "wiw", "cac", "wiw", 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack(), 'i', "ingotIron", 'c', BlocksLT.CONDUIT, 'a', EnumMultiMaterialType.ALUMENTUM.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.ADVANCED_VIS_VALVE, " v ", "gcg", " t ", 'v', EnumMultiMaterialType.VIS_CRYSTAL.stack(), 't', EnumMultiMaterialType.TAINTED_CRYSTAL.stack(), 'g', "ingotGold", 'c', BlocksLT.VIS_VALVE));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.ADVANCED_VIS_VALVE, " t ", "gcg", " v ", 'v', EnumMultiMaterialType.VIS_CRYSTAL.stack(), 't', EnumMultiMaterialType.TAINTED_CRYSTAL.stack(), 'g', "ingotGold", 'c', BlocksLT.VIS_VALVE));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.VIS_PURIFIER, "geg", "ses", "geg", 'g', "ingotGold", 'e', EnumMultiMaterialType.ENCHANTED_SILVERWOOD.stack(), 's', BlocksLT.SILVERWOOD_LOG));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksLT.SILVERWOOD_STAIRS, 4), "p  ", "pp ", "ppp", 'p', BlocksLT.SILVERWOOD_PLANKS).setMirrored(true));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.BLAZE_POWDER, EnumMultiMaterialType.CINDERPEARL_POD.stack()));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksLT.SILVERWOOD_PLANKS, 4), BlocksLT.SILVERWOOD_LOG));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsLT.THAUMONOMICON, "fff", "fbf", "fff", 'f', new ItemStack(ItemsLT.DISCOVERY), 'b', Items.BOOK));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsLT.THAUMIUM_HELMET, "ttt", "t t", 't', "ingotThaumium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsLT.THAUMIUM_CHESTPLATE, "t t", "ttt", "ttt", 't', "ingotThaumium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsLT.THAUMIUM_LEGGINGS, "ttt", "t t", "t t", 't', "ingotThaumium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsLT.THAUMIUM_BOOTS, "t t", "t t", 't', "ingotThaumium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.DUPLICATOR, "gpg", "w w", "gpg", 'g', "ingotGold", 'p', EnumMultiMaterialType.ANIMATED_PISTON.stack(), 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack()));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.CRYSTALLIZER, "123", "456", "787", '1', EnumMultiMaterialType.VAPOROUS_CRYSTAL.stack(), '2', EnumMultiMaterialType.VIS_CRYSTAL.stack(), '3', EnumMultiMaterialType.AQUEOUS_CRYSTAL.stack(), '4', EnumMultiMaterialType.EARTHEN_CRYSTAL.stack(), '5', "gemDiamond", '6', EnumMultiMaterialType.FIERY_CRYSTAL.stack(), '7', "ingotGold", '8', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.GENERATOR, "gwg", "wsw", "gwg", 'g', "paneGlass", 'w', EnumMultiMaterialType.ENCHANTED_WOOD.stack(), 's', ItemsLT.STABILIZED_SINGULARITY));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlocksLT.INFUSER_DARK, "oso", "iti", "ooo", 'o', "obsidian", 's', Blocks.STONE_SLAB, 'i', "ingotIron", 't', EnumMultiMaterialType.TAINTED_CRYSTAL.stack()));
		
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlocksLT.CINNABAR_ORE), EnumMultiMaterialType.QUICKSILVER.stack(), 0.3F);
	}
}