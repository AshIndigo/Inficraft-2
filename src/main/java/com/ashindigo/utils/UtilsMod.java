package com.ashindigo.utils;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Small Forge mod to run required methods.
 */
//Make dummy varible declarations to make the set TODO
@Mod(modid = "indigoutils", version = "1.0", name = "IndigoUtils")
public class UtilsMod implements UtilsMain{

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		//UtilsItemBlockLoader.preInitItems();
		//UtilsItemBlockLoader.preInitBlocks();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		UtilsJsonCreator.init("inficraft2", 0);
		UtilsItemBlockLoader.initItems();
		UtilsItemBlockLoader.initBlocks();
	}

	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		UtilsItemBlockLoader.postInitItems();
		UtilsItemBlockLoader.postInitBlocks();
		GameRegistry.registerWorldGenerator(new UtilsWorldgen(), 1);
	}

}
