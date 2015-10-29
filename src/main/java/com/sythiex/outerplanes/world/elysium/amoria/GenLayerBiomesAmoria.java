package com.sythiex.outerplanes.world.elysium.amoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sythiex.outerplanes.OuterPlanes;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class GenLayerBiomesAmoria extends GenLayer
{
	private List<BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];
	
	protected BiomeGenBase[] allowedBiomes = { BiomeGenBase.birchForest, BiomeGenBase.forest, BiomeGenBase.forestHills,
			BiomeGenBase.plains, BiomeGenBase.plains, BiomeGenBase.roofedForest };
			
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
	
	/*
	 * private List<BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];
	 * 
	 * public GenLayerBiomesAmoria(long seed, GenLayer genLayer, WorldType worldType)
	 * {
	 * super(seed);
	 * 
	 * this.parent = genLayer;
	 * 
	 * for(BiomeManager.BiomeType type : BiomeManager.BiomeType.values())
	 * {
	 * com.google.common.collect.ImmutableList<BiomeEntry> biomesToAdd = BiomeManager.getBiomes(type);
	 * 
	 * int idx = type.ordinal();
	 * 
	 * if(biomes[idx] == null)
	 * {
	 * biomes[idx] = new ArrayList<BiomeEntry>();
	 * }
	 * if(biomesToAdd != null)
	 * {
	 * biomes[idx].addAll(biomesToAdd);
	 * }
	 * }
	 * 
	 * // biomes[BiomeManager.BiomeType.COOL.ordinal()].add(new BiomeEntry(OuterPlanes.biomeOceanus, 30));
	 * // biomes[BiomeManager.BiomeType.WARM.ordinal()].add(new BiomeEntry(OuterPlanes.biomeOceanus, 30));
	 * 
	 * int desertIdx = BiomeManager.BiomeType.DESERT.ordinal();
	 * 
	 * if(worldType == WorldType.DEFAULT_1_1)
	 * {
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.desert, 10));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.forest, 10));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.extremeHills, 10));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.swampland, 10));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.plains, 10));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.taiga, 10));
	 * }
	 * else
	 * {
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.desert, 30));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.savanna, 20));
	 * biomes[desertIdx].add(new BiomeEntry(BiomeGenBase.plains, 10));
	 * }
	 * }
	 * 
	 * /**
	 * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
	 * amounts, or biomeList[] indices based on the particular GenLayer subclass.
	 *
	 * public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
	 * {
	 * int[] aint = this.parent.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
	 * int[] aint1 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);
	 * 
	 * for(int i1 = 0; i1 < p_75904_4_; ++i1)
	 * {
	 * for(int j1 = 0; j1 < p_75904_3_; ++j1)
	 * {
	 * this.initChunkSeed((long) (j1 + p_75904_1_), (long) (i1 + p_75904_2_));
	 * int k1 = aint[j1 + i1 * p_75904_3_];
	 * int l1 = (k1 & 3840) >> 8;
	 * k1 &= -3841;
	 * 
	 * // changed to replace all ocean biomes with land biomes
	 * if(isBiomeOceanic(k1))
	 * {
	 * Random rand = new Random();
	 * k1 = rand.nextInt(4) + 1;
	 * }
	 * 
	 * if(k1 == BiomeGenBase.mushroomIsland.biomeID)
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = k1;
	 * }
	 * else if(k1 == 1)
	 * {
	 * if(l1 > 0)
	 * {
	 * if(this.nextInt(3) == 0)
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau.biomeID;
	 * }
	 * else
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau_F.biomeID;
	 * }
	 * }
	 * else
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = getWeightedBiomeEntry(BiomeManager.BiomeType.DESERT).biome.biomeID;
	 * }
	 * }
	 * else if(k1 == 2)
	 * {
	 * if(l1 > 0)
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.jungle.biomeID;
	 * }
	 * else
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = getWeightedBiomeEntry(BiomeManager.BiomeType.WARM).biome.biomeID;
	 * }
	 * }
	 * else if(k1 == 3)
	 * {
	 * if(l1 > 0)
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.megaTaiga.biomeID;
	 * }
	 * else
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = getWeightedBiomeEntry(BiomeManager.BiomeType.COOL).biome.biomeID;
	 * }
	 * }
	 * else if(k1 == 4)
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = getWeightedBiomeEntry(BiomeManager.BiomeType.ICY).biome.biomeID;
	 * }
	 * else
	 * {
	 * aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mushroomIsland.biomeID;
	 * }
	 * }
	 * }
	 * return aint1;
	 * }
	 * 
	 * protected BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type)
	 * {
	 * List<BiomeEntry> biomeList = biomes[type.ordinal()];
	 * int totalWeight = WeightedRandom.getTotalWeight(biomeList);
	 * int weight = BiomeManager.isTypeListModded(type) ? nextInt(totalWeight) : nextInt(totalWeight / 10) * 10;
	 * return (BiomeEntry) WeightedRandom.getItem(biomeList, weight);
	 * }
	 */
}