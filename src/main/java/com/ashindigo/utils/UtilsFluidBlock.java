package com.ashindigo.utils;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Allows for easy creation of fluids
 * @author 19jasonides_a
 *
 */
public class UtilsFluidBlock extends BlockFluidClassic {

	public UtilsFluidBlock(Fluid fluid, Material material, String name) {
		super(fluid, material);
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

}
