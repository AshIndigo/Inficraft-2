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
	
	public UtilsItem(String modid, String name){
		
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public UtilsItem() {
		// TODO Auto-generated constructor stub
	}
}
