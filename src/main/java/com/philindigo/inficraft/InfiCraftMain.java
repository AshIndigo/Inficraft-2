package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsItemBlockLoader;
import com.ashindigo.utils.UtilsMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = InfiCraftMain.modid, version = "1.0", name = "InfiCraft2", dependencies = "required-before:indigoutils")

public class InfiCraftMain implements UtilsMain {
	
	public final static String modid = "inficraft2";

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		UtilsItemBlockLoader.modidreg.add(modid);
		InfiItems.init();
		InfiBlocks.init();
	}

	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}

}
