package com.ashindigo.utils;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * TODO Broken
 * @author 19jasonides_a
 *
 */
public class UtilsBucket extends ItemBucket implements IItemMethods {

	private static String Name;

	public UtilsBucket(Block containedBlock, String name, Fluid fluid, String modid, String translatedName) {
		super(containedBlock);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
		UtilsItem.itemNameList.put(this, name);
		UtilsItem.modItems.put(modid, this);
		UtilsItem.translatedNameList.put(this, translatedName);
		UtilsItemBlockLoader.itemreg.add(this);
		this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
		Name = name;
		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(this), new ItemStack(Items.bucket));
	}

	public String getName() {
		
		return Name;
	}
	
}
