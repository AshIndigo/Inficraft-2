package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Item class which automatically registers the item that is being added.
* @author Ash Indigo
*/
public class UtilsItem extends Item implements IItemMethods {
	
	public static Map<Item, String> itemNameList = new HashMap();
	public static String Name;
	public static ListMultimap<String, Item> modItems = ArrayListMultimap.create();
	public static Map<Item, String> translatedNameList = new HashMap();
	
	/**
	 * Default constructor to add a item
	 * @param modid Mod's MODID
	 * @param name Item Name
	 */
	public UtilsItem(String modid, String name, String translatedName){
		
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		itemNameList.put(this, name);
		translatedNameList.put(this, translatedName);
		Name = name;
		UtilsItemBlockLoader.itemreg.add(this);
		modItems.put(modid, this);
		
	}

	/**
	 * Constructor to initialize a instance of the class
	 */
	public UtilsItem() {
		
	}
	
	public String getName() {
		
		return Name;
	}
}
