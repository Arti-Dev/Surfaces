package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class SlipperySurface extends Surface {
    public SlipperySurface(Block block, BlockFace face) {
        super(block, face);
    }

    Particle.DustOptions dust = new Particle.DustOptions(Color.WHITE, 1);
    public void displayEdgeParticles() {

        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                for (Location l : particleLocations) {
                    if (Math.random() < 0.01) {
                        center.getWorld().spawnParticle(Particle.SNOWFLAKE, l, 1, 0, 0, 0, 0);
                    }
                    center.getWorld().spawnParticle(Particle.REDSTONE, l, 1, 0, 0, 0, 0, dust);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 3);
        taskID = task.getTaskId();
    }

    public void displayParticles() {
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                Location loc = corners.get(0).clone();
                loc.add(remainingDirections.get(0).getVector().multiply(Math.random()));
                loc.add(remainingDirections.get(1).getVector().multiply(Math.random()));
                if (Math.random() < 0.05) {
                    loc.getWorld().spawnParticle(Particle.SNOWFLAKE, loc, 1, 0, 0, 0, 0);
                }
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, dust);
            }
        }.runTaskTimer(Main.getPlugin(), 0, 1);
        taskID = task.getTaskId();
    }
}
