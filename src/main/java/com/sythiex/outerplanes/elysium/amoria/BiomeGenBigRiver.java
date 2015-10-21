package com.sythiex.outerplanes.elysium.amoria;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenRiver;

public class BiomeGenBigRiver extends BiomeGenRiver
{
	public BiomeGenBigRiver(int p_i1971_1_)
	{
		super(p_i1971_1_);
		this.setBiomeName("Big River");
		//this.setColor(255);
		this.setHeight(new BiomeGenBase.Height(0.0F, 2.0F)); //(-0.8F, 0.0F));
		this.topBlock = Blocks.gold_block;
		this.fillerBlock = Blocks.iron_block;
	}
}