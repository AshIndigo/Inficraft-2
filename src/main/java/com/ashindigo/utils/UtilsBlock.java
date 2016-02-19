package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Block class which automatically registers the block that is being added.
* @author Ash Indigo
*/
public class UtilsBlock extends Block implements IItemMethods {
	
	String Name;
	public static Map<Block, String> blockNameList = new HashMap();
	public static ListMultimap<String, Block> modBlocks = ArrayListMultimap.create();
	public static Map<Block, String> translatedNameList = new HashMap();
	
	/**
	 * Constructor used for declaring blocks
	 * @param mat The material for the block
	 * @param modid Your mod's Mod ID
	 * @param name The name of the block
	 */
	public UtilsBlock(Material mat, String modid, String name, String translatedName) {
			super(mat);
			GameRegistry.registerBlock(this, name);
			setUnlocalizedName(modid + "_" + name);
			setCreativeTab(CreativeTabs.tabBlock);
			blockNameList.put(this, name);
			Name = name;
			UtilsItemBlockLoader.blockreg.add(this);
			modBlocks.put(modid, this);
			translatedNameList.put(this, translatedName);
		}
	/**
	 * Default constructor for setting up a variable
	 * @param mat Just use Material.rock
	 */
	public UtilsBlock(Material mat) {
		super(mat);
	}
	
	@Override
	public String getName()
	{
		return Name;
	}
}