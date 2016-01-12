package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsBlockOre;

import net.minecraft.block.material.Material;

public class InfiBlocks {
	
	public static UtilsBlock testore;
	public static UtilsBlockOre oretest;

	public static void init() {
		
		testore = new UtilsBlock(Material.rock, InfiCraftMain.modid, "testore");
		oretest = new UtilsBlockOre(InfiItems.test, testore, 0, testore, InfiCraftMain.modid);
	}
}
