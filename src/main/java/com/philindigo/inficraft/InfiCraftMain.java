package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsMain;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = InfiCraftMain.modid, version = "1.0", name = "InfiCraft2")

public class InfiCraftMain implements UtilsMain {
	
	public final static String modid = "inficraft2";

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		InfiItems.init();
		InfiBlocks.init();
	}

	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {

	}

}
