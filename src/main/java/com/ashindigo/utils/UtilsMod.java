package com.ashindigo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

/**
 * Small Forge mod to run required methods.
 */
// TODO Add fluid rendering and buckets
@Mod(modid = "indigoutils", version = "1.0", name = "IndigoUtils")
public class UtilsMod implements UtilsMain {
	
	static Configuration config;
	public static ArrayList modidList = new ArrayList();
	public boolean debug = Launch.blackboard.get("fml.deobfuscatedEnvironment") != null;

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		UtilsItemBlockLoader.preInitItems();
		UtilsItemBlockLoader.preInitBlocks();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Checks to see if debug mode is enabled and loads items/blocks
		if (debug == true) {
			debugMode();
		}
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
	
	/**
	 * Debug mode for when IndigoUtils is in  a development enviroment.
	 */
	public void debugMode() {
		int runtime = 0;
		System.out.println("Debug Mode is enabled.");
		int modRuntime0 = 0;
		int runtime0 = 0;
		while (modRuntime0 < UtilsMod.modidList.size()) {
		while (runtime0 < UtilsItemBlockLoader.itemreg.size()) {
			UtilsLanguageCreator.init(UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime0]).get(runtime0).getUnlocalizedName(), UtilsItem.translatedNameList.get((UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime0]).get(runtime0))),(String) UtilsItem.modItems.keySet().toArray()[modRuntime0]);
			runtime0++;
		}
		modRuntime0++;
		}
		while (runtime < modidList.size()) {
			UtilsJsonCreator.init((String) modidList.get(runtime));
			runtime++;
		}
	}
	
	/**
	 * Generates modid's in the IndigoUtils config file.
	 * @param modid The modid of a mod
	 * @param configFolder The config folder
	 */
	@Deprecated
	public static void addModReg(String modid, String configFolder) {
		try {
			File modfileOld = new File(configFolder);
			File modfile = new File(modfileOld.getParent() + "/indigoutils.cfg");
			FileWriter fw = new FileWriter(modfile);
			BufferedWriter bw = new BufferedWriter(fw);
			modidList.add(modid);
			int runtime = 0;
			while (runtime  < modidList.size()) {
				bw.write((String) modidList.get(runtime));
				bw.newLine();
				runtime++;
			}
			bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
