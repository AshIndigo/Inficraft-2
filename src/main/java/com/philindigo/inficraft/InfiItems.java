package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsArmor;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsToolset.UtilsSword;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InfiItems {
	
	// Messing with API here - Ash
	static UtilsItem test;
	static UtilsArmor testhelmet;
	static UtilsArmor testchest;
	static UtilsArmor testleg;
	static UtilsArmor testboot;
	static UtilsSword testsword;
	public static ArmorMaterial ARMORGOLDIRON = EnumHelper.addArmorMaterial("GoldIron", "GoldIron", 14, new int[] {2, 6, 4, 2}, 30);
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 2, 400, 5.5F, 2.5F, 30);

	public static void init() {
		
		test = new UtilsItem(InfiCraftMain.modid, "test");
		testsword = new UtilsSword(AlloyMat, "testsword", InfiCraftMain.modid, test);
		testhelmet = new UtilsArmor("testhelm", ARMORGOLDIRON, 0, InfiCraftMain.modid, test);
		UtilsArmor.armorlist.add(testhelmet);
		testchest = new UtilsArmor("testchest", ARMORGOLDIRON, 1, InfiCraftMain.modid, test);
		UtilsArmor.armorlist.add(testchest);
		testleg = new UtilsArmor("testleg", ARMORGOLDIRON, 2, InfiCraftMain.modid, test);
		UtilsArmor.armorlist.add(testleg);
		testboot = new UtilsArmor("testboot", ARMORGOLDIRON, 3, InfiCraftMain.modid, test);
		UtilsArmor.armorlist.add(testboot);
	}

}
