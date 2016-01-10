package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;

import net.minecraft.block.material.Material;

public class InfiBlocks {
	
	public static UtilsBlock testblock;

	public static void init() {
		
		testblock = new UtilsBlock(Material.rock, InfiCraftMain.modid, "testblock");
		
	}

}
