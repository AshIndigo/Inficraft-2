package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * Currently broken
 * @author 19jasonides_a
 */

public class UtilsWorldgen implements IWorldGenerator {

    	public static ArrayList OverworldList = new ArrayList();
    	public static ArrayList NetherList = new ArrayList();
    	public static ArrayList EndList = new ArrayList();
    	static Block block2;

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case 0: oregenOverworld(random, chunkX * 16, chunkZ * 16, world); break;
            case 1: oregenEnd(random, chunkX * 16, chunkZ * 16, world); break;
            case -1: oregenNether(random, chunkX * 16, chunkZ * 16, world); break;
        }
    }
    public static void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
    {
    	block2 = block;
    	WorldGenMinable minable = new WorldGenMinable(block2.getDefaultState(), (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)));
        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, new BlockPos(posX, posY, posZ));
        }
        }
    
	/**
	 * Overwold ore gen method
	 */
	 private static void oregenOverworld(Random random, int x, int z, World world) {
		int runtime = 0;
		UtilsBlockOre ore = new UtilsBlockOre();
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
		UtilsBlockOre ore = new UtilsBlockOre();
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
		UtilsBlockOre ore = new UtilsBlockOre();
		while(runtime < EndList.size()){
			addOreSpawn((Block) EndList.get(runtime), world, random, x, z, 10, 15, 8, 0, 128);
			runtime++;
			} 
		
	}
}