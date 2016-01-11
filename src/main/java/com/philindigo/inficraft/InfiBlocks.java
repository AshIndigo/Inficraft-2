package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsBlockOre;

import net.minecraft.block.material.Material;

public class InfiBlocks {
	
	public static UtilsBlockOre testblock;
	static UtilsBlock testcompressed;
	static UtilsBlock testore;

	public static void init() {
		
		testcompressed = new UtilsBlock(Material.rock, InfiCraftMain.modid, "testcomp");
		testore = new UtilsBlock(Material.rock, InfiCraftMain.modid, "testore");
		testblock = new UtilsBlockOre(Material.rock, InfiItems.test, testore, 0, testcompressed, InfiCraftMain.modid, "testblock");
	}
}
