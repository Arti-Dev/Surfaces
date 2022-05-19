package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class StickySurface extends Surface{
    public StickySurface(Block block, BlockFace face) {
        super(block, face);
    }

    @Override
    public void displayParticles() {
        Particle.DustOptions dust = new Particle.DustOptions(Color.LIME, 1);

        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                for (Location l : particleLocations) {
                    if (Math.random() < 0.03) {
                        center.getWorld().spawnParticle(Particle.SLIME, l, 1, 0, 0, 0, 0);
                    }
                    center.getWorld().spawnParticle(Particle.REDSTONE, l, 1, 0, 0, 0, 0, dust);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 3);
        taskID = task.getTaskId();
    }

}
