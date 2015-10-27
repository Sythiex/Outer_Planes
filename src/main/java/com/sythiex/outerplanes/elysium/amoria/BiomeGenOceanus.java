package com.sythiex.outerplanes.elysium.amoria;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenOceanus extends BiomeGenOcean
{
	public BiomeGenOceanus(int id)
	{
		super(id);
		this.setBiomeName("Oceanus");
		this.setColor(112);
		this.setHeight(new BiomeGenBase.Height(-0.5F, 0.2F));
	}
}