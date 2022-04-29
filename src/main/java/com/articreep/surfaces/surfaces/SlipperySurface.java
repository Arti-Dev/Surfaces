package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.utils.Directions;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;

import java.sql.Array;
import java.util.ArrayList;

public class SlipperySurface extends Surface {
    public SlipperySurface(Block block, SurfaceDirection direction) {
        super(block, direction);
    }

    @Override
    public void run() {
        for (Location l : locations) {
            l.getWorld().spawnParticle(Particle.SNOWBALL, l, 2, 0.1, 0.1, 0.1);
        }
    }
}
