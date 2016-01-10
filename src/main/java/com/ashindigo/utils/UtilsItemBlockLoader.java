package com.ashindigo.utils;

public class UtilsItemBlockLoader {
	
	public static void preInitItems() {
	}
		
	public static void initItems() {
		/**
		 * Load the automatic item, tool, and armor registers 
		 */
		UtilsItem.register();
		UtilsArmor.register();
		UtilsArmor.registerRecipes();
		UtilsToolset.register();
		UtilsToolset.registerRecipes();
	}
	
	public static void postInitItems() {
	}
	
	public static void preInitBlocks() {
	}
		
	public static void initBlocks() {
		/**
		 * Load the automatic block registers
		 */
		UtilsBlock.register();
		UtilsBlockOre.generate();
	}
	
	public static void postInitBlocks() {
	   /**
		* Load the recipe handlers for ores 
		*/
		UtilsBlockOre.registerRecipes();
	}

}
