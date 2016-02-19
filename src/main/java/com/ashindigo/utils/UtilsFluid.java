package com.ashindigo.utils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class UtilsFluid extends Fluid {

	public UtilsFluid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		FluidRegistry.registerFluid(this);
		setUnlocalizedName(fluidName);
	}

}
