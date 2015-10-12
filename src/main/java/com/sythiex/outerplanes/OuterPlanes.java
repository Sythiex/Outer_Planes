package com.sythiex.outerplanes;

import com.sythiex.outerplanes.elysium.PortalElysium;
import com.sythiex.outerplanes.elysium.WorldProviderElysium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

@Mod(modid = OuterPlanes.MODID, version = OuterPlanes.VERSION)
public class OuterPlanes
{
	public static final String MODID = "outerplanes";
	public static final String VERSION = "0.1.0";
	
	public static int dimElysiumID;
	
	public static Block portalBlockElysium;
	
	public static Item portalMaker;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		ConfigCategory dimensionIDs = new ConfigCategory("Dimension IDs");
		dimElysiumID = config.get("Dimension IDs", "Elysium ID", 2).getInt();
		
		config.save();
		
		DimensionManager.registerProviderType(dimElysiumID, WorldProviderElysium.class, false);
		DimensionManager.registerDimension(dimElysiumID, dimElysiumID);
		
		MinecraftForge.ORE_GEN_BUS.register(new OreGenEventHandler());
		
		registerBlocks();
		registerItems();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
	
	private void registerBlocks()
	{
		portalBlockElysium = new PortalElysium();
		GameRegistry.registerBlock(portalBlockElysium, "portalElysium");
	}
	
	private void registerItems()
	{
		portalMaker = new PortalMaker();
		GameRegistry.registerItem(portalMaker, "portalMaker");
	}
}