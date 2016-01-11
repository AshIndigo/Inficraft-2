package com.ashindigo.utils;

public class UtilsItemBlockLoader {
	
	public static void preInitItems() {
		
	}
		
	public static void initItems() {

	}
	
	public static void postInitItems() {
		
		UtilsToolset.registerRecipes();
		UtilsArmor.registerRecipes();
	}
	
	public static void preInitBlocks() {
	}
		
	public static void initBlocks() {
		/**
		 * Load the automatic block registers
		 */
		UtilsBlockOre.generate();
	}
	
	public static void postInitBlocks() {
	   /**
		* Load the recipe handlers for ores 
		*/
		UtilsBlockOre.registerRecipes();
	}

}
