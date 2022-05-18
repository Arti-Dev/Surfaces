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
    
    public void run() {
        Particle.DustOptions dust = new Particle.DustOptions(Color.WHITE, 1);
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                for (Location l : particleLocations) {
                    if (Math.random() < 0.01) {
                    center.getWorld().spawnParticle(Particle.SNOWFLAKE, l, 1, 0, 0, 0, 0);
                }
                center.getWorld().spawnParticle(Particle.REDSTONE, l, 1, 0, 0, 0, 0, dust);
            }
        }.runTaskTimer(Main.getPlugin(), 0, 3);
        taskID = task.getTaskId();
    }
}
