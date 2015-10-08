package com.sythiex.outerplanes.elysium;

import com.sythiex.outerplanes.OuterPlanes;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderElysium extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 1.0F);
		this.dimensionId = OuterPlanes.dimElysiumID;
	}
	
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderElysium(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName()
	{
		return "Elysium";
	}
}