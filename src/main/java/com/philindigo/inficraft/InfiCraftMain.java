package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

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
		if(event.getSide() == Side.CLIENT)
		{
		    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		    		System.out.println("hi");
		    	renderItem.getItemModelMesher().register(InfiItems.test, 0, new ModelResourceLocation(modid + ":" + ((UtilsItem) InfiItems.test).getName()));
		}
	}

}
