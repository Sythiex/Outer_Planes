package com.sythiex.outerplanes.elysium.amoria;

import com.sythiex.outerplanes.OuterPlanes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderAmoria extends WorldProvider
{
	@Override
	/** tells Minecraft to use our new Terrain Generator */
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderAmoria(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	/** tells Minecraft to use our new WorldChunkManager **/
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerAmoria(worldObj.getSeed(), terrainType);
		this.dimensionId = OuterPlanes.dimAmoriaID;
	}
	
	/** Get Provider for Dimension **/
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(OuterPlanes.dimAmoriaID);
	}
	
	@Override
	/**
	 * @return the name of the dimension
	 */
	public String getDimensionName()
	{
		return "Amoria, Elysium";
	}
	
	@Override
	/** sets/creates the save folder */
	public String getSaveFolder()
	{
		return "DIM" + OuterPlanes.dimAmoriaID;
	}
	
	@Override
	/** can the player respawn in this dimension? */
	public boolean canRespawnHere()
	{
		return true;
	}
	
	@Override
	/** is this a surface world or an underworld */
	public boolean isSurfaceWorld()
	{
		return true;
	}
}