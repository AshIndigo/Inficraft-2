package com.ashindigo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Automatic Json creator
 * @author Ash Indigo
 */
public class UtilsJsonCreator {
	
	static File configFolder =  UtilsMod.config.getConfigFile().getParentFile();
	static FileWriter fw;
	static BufferedWriter bw;
	static File mainloc = new File(configFolder + "/IndigoUtils/");
	static int runtime1 = 0;
	static int runtime2 = 0;
	static int runtime3 = 0;
	static int runtime4 = 0;
	
	/**
	 * Starts the auto json creator
	 * @param modid The Mod's Modid
	 * @author Ash Indigo
	 */
	public static void init(String modid) {
		File modFolderItem = new File(mainloc, modid + "/models/item");
		File modFolderBlock = new File(mainloc, modid + "/models/block");
		File modFolderBlockstate = new File(mainloc, modid + "/blockstates");
		try {
			mainloc.mkdirs();
			mainloc.createNewFile();
			modFolderItem.mkdirs();
			modFolderBlock.mkdirs();
			modFolderBlockstate.mkdirs();
			while (runtime1 < UtilsItem.itemNameList.size()) {
				File itemJson = new File(modFolderItem, UtilsItem.itemNameList.get(runtime1) + ".json");
				fw = new FileWriter(itemJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				itemJson.createNewFile();
				itemJsonCreate(modid, (String) UtilsItem.itemNameList.get(runtime1));
			}
			while (runtime2 < UtilsBlock.blockNameList.size()) {
				File blockJson = new File(modFolderBlock, UtilsBlock.blockNameList.get(runtime2) + ".json");
				blockJson.createNewFile();
				blockJsonCreate(modid, (String) UtilsBlock.blockNameList.get(runtime2));
				runtime2++;
			}
			while (runtime3 < UtilsBlock.blockNameList.size()) {
				File blockstateJson = new File(modFolderBlockstate, UtilsBlock.blockNameList.get(runtime3) + ".json");
				blockstateJson.createNewFile();
				blockstateJsonCreate(modid, (String) UtilsBlock.blockNameList.get(runtime3));
				runtime3++;
			}
			while (runtime4 < UtilsBlock.blockNameList.size()) {
				File blockItemJson = new File(modFolderItem, UtilsBlock.blockNameList.get(runtime4) + ".json");
				blockItemJson.createNewFile();
				blockItemJsonCreate(modid, (String) UtilsBlock.blockNameList.get(runtime4));
				runtime4++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void itemJsonCreate(String modid, String name) {
		try {
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + name);
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -3 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			runtime1++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void blockJsonCreate(String modid, String name) {
		// TODO Auto-generated method stub
		
	}

	private static void blockstateJsonCreate(String modid, String name) {
		// TODO Auto-generated method stub
		
	}

	private static void blockItemJsonCreate(String modid, String name) {
		// TODO Auto-generated method stub
		
	}
}