package com.sythiex.outerplanes.elysium.amoria.layer;

import com.sythiex.outerplanes.OuterPlanes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesAmoria extends GenLayer
{
	protected BiomeGenBase[] allowedBiomes = { BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, 
			BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, 
			BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, 
			BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, 
			BiomeGenBase.taigaHills/*, OuterPlanes.biomeBigRiver*/};
	
	public GenLayerBiomesAmoria(long seed)
	{
		super(seed);
	}
	
	public GenLayerBiomesAmoria(long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width * depth);
		for(int dz = 0; dz < depth; dz++)
		{
			for(int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}