package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsToolset;
import com.ashindigo.utils.UtilsToolset.UtilsSword;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InfiItems {
	
	static UtilsItem test;
	static UtilsSword testsword;
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 2, 400, 5.5F, 2.5F, 30);

	public static void init() {
		
		test = new UtilsItem(InfiCraftMain.modid, "test");
		testsword = new UtilsSword(AlloyMat, "testsword", InfiCraftMain.modid, test);
	}

}
