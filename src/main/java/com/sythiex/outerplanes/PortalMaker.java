package com.sythiex.outerplanes;

import com.sythiex.outerplanes.elysium.TeleporterElysium;
import com.sythiex.outerplanes.elysium.TeleporterElysium.PortalPosition;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;

public class PortalMaker extends Item
{
	public PortalMaker()
	{
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int metadata, float sideX, float sideY, float sideZ)
    {
        if(!world.isRemote)
        {
        	world.setBlock(x, y, z, Blocks.gold_block, 0, 2);
        	
        	world.setBlock(x, y + 1, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x, y + 2, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x, y + 3, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x, y + 4, z, Blocks.gold_block, 0, 2);
        	
        	world.setBlock(x + 1, y, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 2, y, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 3, y, z, Blocks.gold_block, 0, 2);
        	
        	world.setBlock(x + 3, y + 1, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 3, y + 2, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 3, y + 3, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 3, y + 4, z, Blocks.gold_block, 0, 2);
        	
        	world.setBlock(x + 1, y + 4, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 2, y + 4, z, Blocks.gold_block, 0, 2);
        	world.setBlock(x + 3, y + 4, z, Blocks.gold_block, 0, 2);
        	
        	world.setBlock(x + 1, y + 1, z, OuterPlanes.portalBlockElysium, 0, 2);
        	world.setBlock(x + 2, y + 1, z, OuterPlanes.portalBlockElysium, 0, 2);
        	world.setBlock(x + 1, y + 2, z, OuterPlanes.portalBlockElysium, 0, 2);
        	world.setBlock(x + 2, y + 2, z, OuterPlanes.portalBlockElysium, 0, 2);
        	world.setBlock(x + 1, y + 3, z, OuterPlanes.portalBlockElysium, 0, 2);
        	world.setBlock(x + 2, y + 3, z, OuterPlanes.portalBlockElysium, 0, 2);

        	return true;
        }
        return false;
    }
}