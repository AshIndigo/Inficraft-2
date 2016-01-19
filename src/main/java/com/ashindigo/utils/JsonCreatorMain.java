package com.ashindigo.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//@Mod(modid = "indigojsoncreator", version = "1.0", name = "JsonCreator")
public class JsonCreatorMain {

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) throws IOException {
		
		StringBuilder b = new StringBuilder();
		FileReader fr = new FileReader("how");
		BufferedReader br = new BufferedReader(fr);
		br.close();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
		
	}

}
