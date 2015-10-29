package com.sythiex.outerplanes.event;

import cpw.mods.fml.common.eventhandler.Event.Result;

import com.sythiex.outerplanes.OuterPlanes;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class OreGenEventHandler
{
	/**
	 * disables valuable ores in peaceful dimensions
	 * @param event
	 */
	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onEventGenerateMinable(GenerateMinable event)
	{
		if(event.world.provider.dimensionId == OuterPlanes.dimIDAmoria)
		{
			if(!event.type.equals(event.type.COAL) || event.type.equals(event.type.DIRT) || event.type.equals(event.type.GRAVEL))
			{
				event.setResult(Result.DENY);
			}
			else
			{
				event.setResult(Result.DEFAULT);
			}
		}
	}
}