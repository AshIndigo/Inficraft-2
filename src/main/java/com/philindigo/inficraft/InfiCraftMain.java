package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsItemBlockLoader;
import com.ashindigo.utils.UtilsJson;
import com.ashindigo.utils.UtilsMain;
import com.ashindigo.utils.UtilsMod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@UtilsJson
@Mod(modid = InfiCraftMain.modid, version = "1.0", name = "InfiCraft2", dependencies = "required-before:indigoutils")

public class InfiCraftMain implements UtilsMain {
	
	public final static String modid = "inficraft2";
	Configuration config;

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		System.out.println(3);
		UtilsMod.addModReg(modid, event.getSuggestedConfigurationFile().getAbsolutePath());
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
