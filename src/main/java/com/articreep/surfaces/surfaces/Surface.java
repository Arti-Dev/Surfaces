package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.utils.Directions;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public abstract class Surface extends BukkitRunnable {
    Block block;
    SurfaceDirection direction;
    ArrayList<Location> locations = new ArrayList<>();

    public Surface(Block block, SurfaceDirection direction) {
        this.block = block;
        this.direction = direction;
        computeCorners();
    }

    // Based on the direction, get coordinates
    private void computeCorners() {
        // Have a small array containing "x, y, z"
        // Clone the location of the object
        // Select the variable that will remain constant, and remove it from the array.
        // If it's a +1 direction add 1 to the current one and add to list, if not then just add to list.
        // On the remaining two: copy in between each location generated:
        // Add 1 to the first coordinate.
        // Add 1 to the second coordinate.
        // Subtract 1 from the first coordinate.
        // Return list.

        // This is kinda bad but ok
        ArrayList<Directions> remainingDirections = new ArrayList<>();
        remainingDirections.add(Directions.X);
        remainingDirections.add(Directions.Y);
        remainingDirections.add(Directions.Z);

        Location loc1 = block.getLocation().clone();

        loc1.add(direction.getDirection().getVector());
        locations.add(loc1);

        remainingDirections.remove(direction.getDirection());
        Location loc2 = loc1.clone().add(remainingDirections.get(0).getVector());
        Location loc3 = loc2.clone().add(remainingDirections.get(1).getVector());
        Location loc4 = loc3.clone().subtract(remainingDirections.get(0).getVector());
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
    }

    public abstract void run();
}
