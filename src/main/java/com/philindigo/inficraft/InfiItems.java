package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsArmor;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsToolset;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InfiItems {
	
	public static UtilsItem test;
	public static UtilsItem test2;
	public static UtilsItem test3;
	public static ArmorMaterial ARMORGOLDIRON = EnumHelper.addArmorMaterial("GoldIron", "GoldIron", 14, new int[] {2, 6, 4, 2}, 30);
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 2, 400, 5.5F, 2.5F, 30);

	public static void init() {
		
		test = new UtilsItem(InfiCraftMain.modid, "test");
		test3 = new UtilsItem(InfiCraftMain.modid, "test3");
		test2 = new UtilsItem(InfiCraftMain.modid, "test2");
		/*
		UtilsArmor helm = new UtilsArmor("helm", ARMORGOLDIRON, 0, "inficraft2", test);
		UtilsArmor chest = new UtilsArmor("chest", ARMORGOLDIRON, 1, "inficraft2", test);
		UtilsArmor leg = new UtilsArmor("leg", ARMORGOLDIRON, 2, "inficraft2", test);
		UtilsArmor boot = new UtilsArmor("boot", ARMORGOLDIRON, 3, "inficraft2", test);
		*/
		UtilsToolset testtools = new UtilsToolset(AlloyMat, "testto", "inficraft2", test);
		UtilsToolset testtools2 = new UtilsToolset(AlloyMat, "testto2", "inficraft2", test2);
		UtilsArmor.createArmorSet("testarmor", ARMORGOLDIRON, "inficraft2", test);
		UtilsArmor.createArmorSet("testarmor2", ARMORGOLDIRON, "inficraft2", test2);
	}

}
