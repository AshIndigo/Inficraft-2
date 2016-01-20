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

import com.google.common.reflect.ClassPath;

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
@Mod(modid = "indigoutils", version = "1.0", name = "IndigoUtils")
public class UtilsMod implements UtilsMain{
	
	static Configuration config;
	static JarFile jarfile;
	static JarEntry je;
	static Class mod;
	static URLClassLoader urlclass;
	static JarInputStream jis; 
	static ClassLoader classLoader = UtilsMod.class.getClassLoader();
	static ArrayList modidList = new ArrayList();
	static ArrayList markedJars = new ArrayList();
	static ArrayList jars = new ArrayList();
	static String loc;

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		//UtilsItemBlockLoader.preInitItems();
		//UtilsItemBlockLoader.preInitBlocks();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		UtilsJsonCreator.init("inficraft2");
		UtilsItemBlockLoader.initItems();
		UtilsItemBlockLoader.initBlocks();
		checkForJsonAnnotation();
	}
	
	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		UtilsItemBlockLoader.postInitItems();
		UtilsItemBlockLoader.postInitBlocks();
		GameRegistry.registerWorldGenerator(new UtilsWorldgen(), 1);
	}

	public static void checkForJsonAnnotation() {
		try {
		// Sets up variables for files and folders
				File assets = new File(UtilsMod.class.getProtectionDomain().getCodeSource().getLocation().getPath());
				File bin = new File(assets.getParentFile().getParentFile().getParentFile().getParentFile().toString() + "/");
				File[] jarfiles = bin.listFiles();
				Enumeration em1;
				// Starts the annotation detection
				// Gets jar files added to ArrayList
				int runtime = 0;
				while (runtime < jarfiles.length) {
					jars.add(jarfiles[runtime]);
					runtime++;
				}
				// Starts trying to find mods with the UtilsJson annotation
				// Dont try to comprehend
				int runtime2 = 0;
				while (runtime2 < jars.size()) {
					if (jars.get(runtime2).toString().endsWith(".jar")) {
					jarfile = new JarFile(jars.get(runtime2).toString());
					File jarfilee = new File(jars.get(runtime2).toString() + "/");
					em1 = jarfile.entries();
					while (em1.hasMoreElements()) {
						if (em1.nextElement().toString().endsWith(".class")) {
							URL[] binurl = { jarfilee.toURL() };
							urlclass = new URLClassLoader(binurl, UtilsMod.class.getClassLoader());
							FileInputStream fis = new FileInputStream(jarfilee);
							jis = new JarInputStream(fis);
							while ((je = jis.getNextJarEntry()) != null) {
								if (je.getName().endsWith(".class")) {
									if (em1.hasMoreElements() == true) {
									loc = em1.nextElement().toString().replace('/', '.');
									} if (loc.endsWith(".") == false) {
										if (loc.endsWith(".info") == false) {
											if (loc.endsWith(".json") == false) {
												if (loc.endsWith(".png") == false) {
													mod = urlclass.loadClass(loc.replace(".class", ""));
													if (mod.isAnnotationPresent(Mod.class)) {
														markedJars.add(mod);
														System.out.println(markedJars);
													}
												}
											}
										}
									}
								}
							}
						}
					}
					}
					runtime2++;
				}
					jarfile.close();
					if (jis != null) {
						jis.close();
						}
						if (urlclass != null) {
							urlclass.close();
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	//@SuppressWarnings(value = { "resource" })
	@Deprecated
	/**
	 * Please dont use
	 * @param modid The modid of a mod
	 * @param configFolder The config folder
	 */
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
