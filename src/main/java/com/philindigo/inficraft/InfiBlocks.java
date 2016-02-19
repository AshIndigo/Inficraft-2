package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsBlockOre;
import com.ashindigo.utils.UtilsBucket;
import com.ashindigo.utils.UtilsFluid;
import com.ashindigo.utils.UtilsFluidBlock;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class InfiBlocks {
	
	public static UtilsBlock testore;
	public static UtilsBlockOre oretest;
	public static UtilsFluidBlock testfl;
	public static UtilsFluid fl;
	
	public static void init() {
		
		testore = new UtilsBlock(Material.rock, InfiCraftMain.modid, "testore", "testOre");
		fl = new UtilsFluid("fl", new ResourceLocation("fls"), new ResourceLocation("fll"));
		testfl = new UtilsFluidBlock(fl, Material.water, "testfl");
		UtilsBucket tbucket = new UtilsBucket(InfiBlocks.testfl, "tbucket", InfiBlocks.fl, "inficraft2", "Test Bucket");
		oretest = new UtilsBlockOre(InfiItems.test, testore, 0, testore, InfiCraftMain.modid);
	}
}
