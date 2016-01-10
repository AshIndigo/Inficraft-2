package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class UtilsWorldgen implements IWorldGenerator {

    	public static ArrayList OverworldList = new ArrayList();
    	public static ArrayList NetherList = new ArrayList();
    	public static ArrayList EndList = new ArrayList();

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case 0: GenerateOverworld(random, chunkX * 16, chunkZ * 16, world); break;
            case 1: GenerateEnd(random, chunkX * 16, chunkZ * 16, world); break;
            case -1: GenerateNether(random, chunkX * 16, chunkZ * 16, world); break;
        }
    }
    public static void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
    {
        WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.stone);
        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
        }

    public static void GenerateOverworld(Random random, int x, int z, World world) {

    	oregenOverworld(random, x, z, world);
    }

  
    public static void GenerateNether(Random random, int x, int z, World world) {
    	
    	oregenNether(random, x, z, world);
    }

    public static void GenerateEnd(Random random, int x, int z, World world) {
    	
    	oregenEnd(random, x, z, world);
    }
	
	/**
	 * Overwold ore gen method
	 */
	 private static void oregenOverworld(Random random, int x, int z, World world) {
		int runtime = 0;
		UtilsBlockOre ore = new UtilsBlockOre(Material.rock);
		while(runtime < OverworldList.size()){
			addOreSpawn((Block) OverworldList.get(runtime), world, random, x, z, 10, 15, 8, 0, 128);
			runtime++;
			} 
	}
	
	/**
	 * Nether ore gen method
	 */
	 private static void oregenNether(Random random, int x, int z, World world) {
	    int runtime = 0;
		UtilsBlockOre ore = new UtilsBlockOre(Material.rock);
		while(runtime < NetherList.size()){
			addOreSpawn((Block) NetherList.get(runtime), world, random, x, z, 10, 15, 8, 0, 128);
			runtime++;
			} 	
	}
		 
	/**
	 * End ore gen method
	 */
	private static void oregenEnd(Random random, int x, int z, World world) {
		int runtime = 0;
		UtilsBlockOre ore = new UtilsBlockOre(Material.rock);
		while(runtime < EndList.size()){
			addOreSpawn((Block) EndList.get(runtime), world, random, x, z, 10, 15, 8, 0, 128);
			runtime++;
			} 
		
	}
}