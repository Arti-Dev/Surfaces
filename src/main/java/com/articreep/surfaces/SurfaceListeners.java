package com.articreep.surfaces;

import com.articreep.surfaces.surfaces.SlipperySurface;
import com.articreep.surfaces.surfaces.SpecificBlockFace;
import com.articreep.surfaces.surfaces.Surface;
import com.articreep.surfaces.surfaces.SurfaceManager;
import com.articreep.surfaces.utils.Direction;
import com.articreep.surfaces.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SurfaceListeners implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.isCancelled()) return;
        Block blockAgainst = e.getBlockAgainst();
        Block blockPlaced = e.getBlockPlaced();
        BlockFace face = Utils.computeBlockFace(blockAgainst, blockPlaced);
        if (face == null) return;
        SpecificBlockFace specificFace = new SpecificBlockFace(blockAgainst, Utils.computeBlockFace(blockAgainst, blockPlaced));
        // If it is a slippery surface
        if (SurfaceManager.hasSurface(specificFace) && SurfaceManager.getSurfaceType(specificFace) == SlipperySurface.class) {
            Location targetLoc = blockPlaced.getLocation().add(Direction.CENTER.getVector());
            blockPlaced.getWorld().spawnFallingBlock(targetLoc, blockPlaced.getType().createBlockData());
            blockPlaced.setType(Material.AIR);
        }
    }
}
