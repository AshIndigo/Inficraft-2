package com.ashindigo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Automatic Json creator
 * @author Ash Indigo
 */
public class UtilsJsonCreator {
	
	static ClassLoader loader = UtilsMain.class.getClassLoader();
	static PrintWriter pwItem;
	static File itemJson;
	static File blockJson;
	static FileReader fr;
	
	/**
	 * Starts the auto json creator
	 * @param modid The Mod's Modid
	 * @param mode The mode of the script. 0 = Items 1 = Blocks
	 * @throws FileNotFoundException The world is burning
	 */
	public static void init(String modid, int mode) {
		
		String itemloc = loader.getResource("").toString() + "assets/" + modid + "/models/item/";
		String blockloc = loader.getResource("").toString() + "assets/" + modid + "/models/block/";
		itemJson = new File(itemloc + "/item.json");
		blockJson = new File(blockloc + "");
		System.out.println(itemloc);
		System.out.println(blockloc);
		System.out.println(itemJson);
		System.out.println(blockJson);
		switch (mode) {
		case 0: //initItem(modid); break;
		case 1: //initBlock(modid); break;
		}
	}

	private static void initItem(String modid) {
		try {
			int runtime = 0;
			pwItem = new PrintWriter(itemJson);
			pwItem.println("");
			pwItem.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void initBlock(String modid) {
		
	}
}
