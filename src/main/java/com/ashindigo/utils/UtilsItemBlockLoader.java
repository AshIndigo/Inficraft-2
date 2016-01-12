package com.ashindigo.utils;

import java.util.ArrayList;

import com.philindigo.inficraft.InfiBlocks;
import com.philindigo.inficraft.InfiCraftMain;
import com.philindigo.inficraft.InfiItems;

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
	
	public static ArrayList itemreg = new ArrayList();
	public static ArrayList blockreg = new ArrayList();
	public static ArrayList modidreg = new ArrayList();
	public static ItemModelMesher itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	
	// Dont touch
	public static void preInitItems() {
		
	}
	/**
	* Start the auto json register (Try that modid function out)
	* @author Ash Indigo
	*/
	public static void initItems() {
		
		int runtime = 0;
		int modruntime = 0;
		while (modruntime < modidreg.size()) {
		while (runtime < itemreg.size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				
				itemRender.register((UtilsItem) itemreg.get(runtime), 0, new ModelResourceLocation(modidreg.get(modruntime) + ":" + ((UtilsItem) itemreg.get(runtime)).getName() , "inventory"));
			}
			runtime++;
		}
		modruntime++;
		}
	}
	
	// Loads recipes
	public static void postInitItems() {
		
		UtilsToolset.registerRecipes();
		UtilsArmor.registerRecipes();
	}
	
	// Dont touch
	public static void preInitBlocks() {
		
	}
	/**
	 * Initiates the auto model loader
	 * @author Ash Indigo
	 */
	public static void initBlocks() {
		
		int runtime = 0;
		int modruntime = 0;
		while (modruntime < modidreg.size()) {
		while (runtime < blockreg.size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				
				itemRender.register(Item.getItemFromBlock((UtilsBlock) blockreg.get(runtime)), 0, new ModelResourceLocation(modidreg.get(modruntime) + ":" + ((UtilsBlock) blockreg.get(runtime)).getName(), "inventory"));
			}
			runtime++;
		}
		modruntime++;
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
