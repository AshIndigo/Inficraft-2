package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
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
	
	public static int runtime = 0;
	public static ArrayList toollists = new ArrayList();
	public static Item Material;
	public static Item pickaxe;
	public static Item axe;
	public static Item sword;
	public static Item hoe;
	public static Item shovel;

	/**
	 * 
	 * @param material The ToolMaterial for the set.
	 * @param name The name of the item will have the tool's function added to it. I.E If the name is Test then the resulting name will be Testpickaxe
	 * @param modid The Mod's Modid.
	 * @param toolmat The item used to create the tools.
	 */
	public UtilsToolset(ToolMaterial material, String name, String modid, Item toolmat) {
		Item dummypickaxe = new UtilsPickaxe(material, name + "pickaxe", modid, toolmat);
		Item dummyaxe = new UtilsAxe(material, name + "axe", modid, toolmat);
		Item dummysword = new UtilsSword(material, name + "sword", modid, toolmat);
		Item dummyhoe = new UtilsHoe(material, name + "hoe", modid, toolmat);
		Item dummyshovel = new UtilsShovel(material, name + "shovel", modid, toolmat);
	}
	
	public static class UtilsPickaxe extends ItemPickaxe{

		public UtilsPickaxe(ToolMaterial material, String name, String modid, Item toolmat) {
			super(material);
			GameRegistry.registerItem(this, name);
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.tabCombat);
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
}