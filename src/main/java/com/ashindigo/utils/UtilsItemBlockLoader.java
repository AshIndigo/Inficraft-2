package com.ashindigo.utils;

import java.util.ArrayList;

import com.philindigo.inficraft.InfiItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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
	static ArrayList json = new ArrayList();
	public static ItemModelMesher itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	
	// Dont touch
	public static void preInitItems() {
		
	}
	/**
	* Start the auto json register
	* Modid function may be broken
	* @author Ash Indigo
	*/
	public static void initItems() {
		
		int runtime = 0;
		int modruntime = 0;
		while (modruntime < modidreg.size()) {
		while (runtime < itemreg.size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				
				ModelLoader.setCustomModelResourceLocation((Item) itemreg.get(runtime), 0, new ModelResourceLocation((String) json.get(runtime), "inventory"));
				//itemRender.simpleShapes.put(Integer.valueOf(itemRender.getIndex((UtilsItem) itemreg.get(runtime), 0)), location);
				//itemRender.simpleShapesCache.put(Integer.valueOf(itemRender.getIndex((UtilsItem) itemreg.get(runtime), 0)), itemRender.getModelManager().getModel(location));
				//itemRender.register((UtilsItem) itemreg.get(runtime), 0, new ModelResourceLocation(modidreg.get(modruntime) + ":" + ((UtilsItem) itemreg.get(runtime)).getName(), "inventory"));
			}
			runtime++;
		}
		modruntime++;
		}
	}
	
	/**
	 * Loads recipes
	 */
	public static void postInitItems() {
		
		UtilsToolset.registerRecipes();
		UtilsArmor.registerRecipes();
		
	}
	
	// Dont touch
	public static void preInitBlocks() {
		
	}
	/**
	 * Initiates the auto model loader
	 * Modid function may be broken
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
