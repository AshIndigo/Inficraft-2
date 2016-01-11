package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * A class dedicated to making tool sets.
 * <p>
 * Example: {@link UtilsToolset.UtilsPickaxe}
 * </p>
 * Will automatically registers recipes for each tool
 * @author 19jasonides_a
 */
public class UtilsToolset {
	
	public static ArrayList listtools = new ArrayList();
	public static int runtime = 0;
	public static String MODID;
	public static String textureName;
	public static ArrayList toollists = new ArrayList();
	public static Item Material;
	public static Item pickaxe;
	public static Item axe;
	public static Item sword;
	public static Item hoe;
	public static Item shovel;

	public UtilsToolset() {
		// TODO Auto-generated constructor stub
	}
	
	public static class UtilsPickaxe extends ItemPickaxe{

		public UtilsPickaxe(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
		    listtools.add(name);
		    Material = toolmat;
		    pickaxe = this;
		    if (this != null){
			    toollists.add(this);
			    }
		}
		
	}
	
	public static class UtilsAxe extends ItemAxe{

		public UtilsAxe(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
		    listtools.add(name);
		    Material = toolmat;
		    axe = this;
		    if (this != null){
			    toollists.add(this);
			    }
		}
		
	}
	
	public static class UtilsSword extends ItemSword{

		public UtilsSword(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
		    listtools.add(name);
		    Material = toolmat;
		    sword = this;
		    if (this != null){
			    toollists.add(this);
			    }
		}
		
	}
	
	public static class UtilsHoe extends ItemHoe{

		public UtilsHoe(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
		    listtools.add(name);
		    Material = toolmat;
		    hoe = this;
		    if (this != null){
			    toollists.add(this);
			    }
		}
		
	}
	
	public static class UtilsShovel extends ItemSpade{

		public UtilsShovel(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
		    listtools.add(name);
		    Material = toolmat;
		    shovel = this;
		    if (this != null){
			    toollists.add(this);
			    }
		}
		
	}
	
	/**
	 * Method that automatically add recipes for tools
	 */
	public static void registerRecipes(){
			if(sword != null){
		GameRegistry.addRecipe(new ItemStack(sword, 1), new Object[]{
	        	" A ",
	        	" A ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
			}
			if(pickaxe != null){
	    	GameRegistry.addRecipe(new ItemStack(pickaxe, 1), new Object[]{
	        	"AAA",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
			}
			if(shovel != null){
	    	GameRegistry.addRecipe(new ItemStack(shovel, 1), new Object[]{
	        	" A ",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
			}
			if(hoe != null){
	    	GameRegistry.addRecipe(new ItemStack(hoe, 1), new Object[]{
	        	"AA ",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
			}
	    	if(hoe != null){
	    	GameRegistry.addRecipe(new ItemStack(hoe, 1), new Object[]{
	        	" AA",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
	    	}
	    	if(axe != null){
	    	GameRegistry.addRecipe(new ItemStack(axe, 1), new Object[]{
	        	"AA ",
	        	"AB ",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
	    	}
	    	if(axe != null){
	    	GameRegistry.addRecipe(new ItemStack(axe, 1), new Object[]{
	        	" AA",
	        	" BA",
	        	" B ",
	        	'A', Material, 'B', Items.stick
	    	});
	    	}
	}
	/**
	 * Method that starts the automatic registration of tools.
	 * Call in init method
	 * See:{@link UtilsMain.init}
	 * Version 1.1
	 */
	public static void register() {
		try{
		while(runtime < listtools.size()){
		GameRegistry.registerItem((Item) toollists.get(runtime), ("indigoapitools" + MODID + runtime));
		runtime++;
		}
		}
		catch(IndexOutOfBoundsException e){
			
		}
	}
}