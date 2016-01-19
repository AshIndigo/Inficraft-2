package com.ashindigo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

import net.minecraftforge.common.config.Configuration;
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
	
	static Configuration config;
	static JarFile jarfile;
	static ClassLoader classLoader = UtilsMod.class.getClassLoader();
	
	static ArrayList modidList = new ArrayList();

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		//UtilsItemBlockLoader.preInitItems();
		//UtilsItemBlockLoader.preInitBlocks();
		// Have 2 jars one to create the .json's the other as the mod
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		try {
		UtilsJsonCreator.init("inficraft2");
		UtilsItemBlockLoader.initItems();
		UtilsItemBlockLoader.initBlocks();
		// End of normal stuff
		// Sets up variables for files and folders
		File assets = new File(UtilsMod.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		File bin = new File(assets.getParentFile().getParentFile().getParentFile().getParentFile().toString());
		URL[] binurl = { bin.toURL() };
		URLClassLoader urlclass = new URLClassLoader(binurl, UtilsMod.class.getClassLoader());;
		ArrayList jars = new ArrayList();
		File[] jarfiles = bin.listFiles();
		Enumeration em1;
		// Starts the annotation detection
		int runtime = 0;
		while (runtime < jarfiles.length) {
			jars.add(jarfiles[runtime]);
			runtime++;
		}
		int runtime2 = 0;
		while (runtime2 < jars.size()) {
			if (jars.get(runtime2).toString().endsWith(".jar")) {
			jarfile = new JarFile(jars.get(runtime2).toString());
			File jarfilee = new File(jars.get(runtime2).toString());
			em1 = jarfile.entries();
			while (em1.hasMoreElements()) {
				if (em1.nextElement().toString().endsWith(".class")) {
					String loc = em1.nextElement().toString();
					String loc2 = loc.replace('/', '.');
					System.out.println(jarfilee);
					FileInputStream fis = new FileInputStream(jarfilee);
					JarInputStream jis = new JarInputStream(fis);
					JarEntry je;
					while ((je = jis.getNextJarEntry()) != null) {
						System.out.println(je.getName());
					}
					jis.close();
					//Class mod = urlclass.loadClass(bin + "/" + jarfile.getName() + "/" + loc);
					//Class mod = urlclass.loadClass(jarfile.getName() + "/");
					//System.out.println(mod);
					/*
				if (mod.isAnnotationPresent(Mod.class)) {
					System.out.println("OMG");
				}
				*/
				}
				
			}
			}
			runtime2++;
		}
			urlclass.close();
			jarfile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		UtilsItemBlockLoader.postInitItems();
		UtilsItemBlockLoader.postInitBlocks();
		GameRegistry.registerWorldGenerator(new UtilsWorldgen(), 1);
	}

	//@SuppressWarnings(value = { "resource" })
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
