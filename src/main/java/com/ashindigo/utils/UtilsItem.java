package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
* An Item class which automatically registers the item that is being added.
* @author Ash Indigo
*/
public class UtilsItem extends Item {
	
	String Name;
	
	public UtilsItem(String modid, String name){
		
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		Name = name;
		UtilsItemBlockLoader.itemreg.add(this);
	}

	public UtilsItem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * No idea why I have this.
	 * @return Returns the items name
	 */
	public String getName()
	{
		return Name;
	}
}
