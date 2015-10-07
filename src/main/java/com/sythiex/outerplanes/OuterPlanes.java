package com.sythiex.outerplanes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = OuterPlanes.MODID, version = OuterPlanes.VERSION)
public class OuterPlanes
{
	public static final String MODID = "outerplanes";
    public static final String VERSION = "0.1.0";
    
    public static int dimElysiumID;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	dimElysiumID = config.get("Dimension IDs", "dimElysiumID", 5).getInt();
    	
    	config.save();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}