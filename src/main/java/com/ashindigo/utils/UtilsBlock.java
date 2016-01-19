package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Block class which automatically registers the block that is being added.
* @author Ash Indigo
*/
public class UtilsBlock extends Block {
	
	String Name;
	public static ArrayList blockNameList = new ArrayList();
	
	/**
	 * Constructor used for declaring blocks
	 * @param mat The material for the block
	 * @param modid Your mod's Mod ID
	 * @param name The name of the block
	 */
	public UtilsBlock(Material mat, String modid, String name) {
			super(mat);
			GameRegistry.registerBlock(this, name);
			setUnlocalizedName(modid + "_" + name);
			setCreativeTab(CreativeTabs.tabBlock);
			blockNameList.add(name);
			Name = name;
			UtilsItemBlockLoader.blockreg.add(this);
		}
	/**
	 * Default constructor for setting up a varible
	 * @param mat Just use Material.rock
	 */
	public UtilsBlock(Material mat) {
		super(mat);
	}
	
	public String getName()
	{
		return Name;
	}
}