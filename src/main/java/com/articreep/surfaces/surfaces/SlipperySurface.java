package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.utils.Direction;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class SlipperySurface extends Surface {
    public SlipperySurface(Block block, BlockFace face) {
        super(block, face);
    }

    @Override
    public void run() {
        Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 1);
        for (Location l : particleLocations) {
            center.getWorld().spawnParticle(Particle.REDSTONE, l, 1, 0, 0, 0, 0, dust);
        }
    }
}
