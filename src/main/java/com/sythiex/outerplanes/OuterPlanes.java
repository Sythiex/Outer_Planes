package com.sythiex.outerplanes;

import com.sythiex.outerplanes.blocks.BlockPortalElysiumAmoria;
import com.sythiex.outerplanes.event.OreGenEventHandler;
import com.sythiex.outerplanes.items.PortalMaker;
import com.sythiex.outerplanes.world.elysium.amoria.GeneratorElysiumAmoria;
import com.sythiex.outerplanes.world.elysium.amoria.WorldProviderAmoria;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
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
	
	public static int dimIDAmoria;
	
	public static Block portalBlockElysium;
	
	public static Item portalMaker;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		ConfigCategory dimensionIDs = new ConfigCategory("Dimension IDs");
		dimIDAmoria = config.get("Dimension IDs", "Amoria ID", 2).getInt();
		
		// ConfigCategory biomeIDs = new ConfigCategory("Biome IDs");
		
		config.save();
		
		DimensionManager.registerProviderType(dimIDAmoria, WorldProviderAmoria.class, false);
		DimensionManager.registerDimension(dimIDAmoria, dimIDAmoria);
		
		GameRegistry.registerWorldGenerator(new GeneratorElysiumAmoria(), 0);
		
		MinecraftForge.ORE_GEN_BUS.register(new OreGenEventHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		registerBlocks();
		registerItems();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
	
	private void registerBlocks()
	{
		portalBlockElysium = new BlockPortalElysiumAmoria();
		GameRegistry.registerBlock(portalBlockElysium, "portalElysium");
	}
	
	private void registerItems()
	{
		portalMaker = new PortalMaker();
		GameRegistry.registerItem(portalMaker, "portalMaker");
	}
}