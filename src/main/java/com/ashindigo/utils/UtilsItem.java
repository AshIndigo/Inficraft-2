package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Item class which automatically registers the item that is being added.
* @author Ash Indigo
*/
public class UtilsItem extends Item {
	
	public static ArrayList listitem = new ArrayList();
	static int runtime = 0;
	public static String MODID;
	public static ArrayList itemlists = new ArrayList();
	
	public UtilsItem(String modid, String name){
		
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		listitem.add(name);
		MODID = modid;
		itemlists.add(this);
	}

	public UtilsItem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method that starts the automatic registration of items.
	 * Call in init method
	 * See:{@link UtilsMain.init}
	 * Version 1.1
	 */
	public static void register() {
		
		while(runtime < listitem.size()){
		GameRegistry.registerItem((Item) itemlists.get(runtime), ("indigoapiitems" + MODID + runtime));
		runtime++;
		}
	}
}
