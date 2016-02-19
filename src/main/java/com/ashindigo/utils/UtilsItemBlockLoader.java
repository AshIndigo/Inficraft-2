package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Manages the item and block apis for IndigoUtils
 * @author Ash Indigo
 */
public class UtilsItemBlockLoader {

	public static ArrayList<Item> itemreg = new ArrayList<Item>();
	public static ArrayList<Block> blockreg = new ArrayList<Block>();
	public static ItemModelMesher itemRender;
	
	public static void preInitItems() {
		
	}
	/**
	* Start the auto json register
	* @author Ash Indigo
	*/
	public static void initItems() {
		try {
		itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		int runtime = 0;
		int modRuntime = 0;
		while (modRuntime < UtilsMod.modidList.size()) {
		while (runtime < UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				System.out.println(UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).get(runtime).getUnlocalizedName());
				itemRender.register((Item) UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).get(runtime), 0, new ModelResourceLocation(UtilsItem.modItems.keySet().toArray()[modRuntime] + ":" + UtilsItem.itemNameList.get(UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).get(runtime)), "inventory"));
			}
			runtime++;
		}
		modRuntime++;
		}
		}
	
	catch (IndexOutOfBoundsException e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * Loads recipes
	 */
	public static void postInitItems() {
		
		UtilsToolset.registerRecipes();
		UtilsArmor.registerRecipes();
		
	}
	
	public static void preInitBlocks() {
		
	}
	
	/**
	 * Initiates the auto model loader
	 * @author Ash Indigo
	 */
	public static void initBlocks() {
		
		itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		int runtime = 0;
		int modRuntime = 0;
		int modRuntime0 = 0;
		int runtime0 = 0;
		while (modRuntime0 < UtilsMod.modidList.size()) {
		while (runtime0 < blockreg.size()) {
			UtilsLanguageCreator.init(UtilsBlock.modBlocks.get((String) UtilsBlock.modBlocks.keySet().toArray()[modRuntime0]).get(runtime0).getUnlocalizedName(), UtilsBlock.translatedNameList.get((UtilsBlock.modBlocks.get((String) UtilsBlock.modBlocks.keySet().toArray()[modRuntime0]).get(runtime0))),(String) UtilsBlock.modBlocks.keySet().toArray()[modRuntime0]);
			runtime0++;
		}
		modRuntime0++;
		}
		while (modRuntime < UtilsMod.modidList.size()) {
		while (runtime < blockreg.size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				itemRender.register(Item.getItemFromBlock(UtilsBlock.modBlocks.get((String) UtilsBlock.modBlocks.keySet().toArray()[modRuntime]).get(runtime)), 0, new ModelResourceLocation(UtilsBlock.modBlocks.keySet().toArray()[modRuntime] + ":" + ((IItemMethods) UtilsBlock.modBlocks.get((String) UtilsBlock.modBlocks.keySet().toArray()[modRuntime]).get(runtime)).getName(), "inventory"));
			}
			runtime++;
		}
		modRuntime++;
		}
		UtilsBlockOre.generate();
	}
	
	public static void postInitBlocks() {
	   /**
		* Load the recipe handlers for ores 
		*/
		UtilsBlockOre.registerRecipes();
	}

}
