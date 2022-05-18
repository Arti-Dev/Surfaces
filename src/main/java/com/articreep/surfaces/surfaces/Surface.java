package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.utils.Direction;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;


public abstract class Surface extends BukkitRunnable {
    Block block;
    BlockFace face;
    ArrayList<Location> corners = new ArrayList<>();
    ArrayList<Location> particleLocations = new ArrayList<>();
    LinkedHashMap<Direction, Integer> map = new LinkedHashMap<>();;
    Location center;
    Direction changingCoord;
    ArrayList<Direction> remainingDirections;

    public Surface(Block block, BlockFace face) {
        this.block = block;
        this.face = face;

        map.put(Direction.X, face.getModX());
        map.put(Direction.Y, face.getModY());
        map.put(Direction.Z, face.getModZ());

        remainingDirections = new ArrayList<>(map.keySet());

        Iterator<Direction> iterator = remainingDirections.iterator();
        while (iterator.hasNext()) {
            Direction direction = iterator.next();
            // Find the non-zero value
            if (map.get(direction) != 0) {
                changingCoord = direction;
                iterator.remove();
            }
        }

        computeCorners();
        computeCenter();
        computeEdges();
    }

    // Based on the direction, get coordinates
    private void computeCorners() {
        Location loc1 = block.getLocation();
        if (map.get(changingCoord) == 1) {
            loc1.add(changingCoord.getVector());
        }
        Location loc2 = loc1.clone().add(remainingDirections.get(0).getVector());
        Location loc3 = loc2.clone().add(remainingDirections.get(1).getVector());
        Location loc4 = loc3.clone().subtract(remainingDirections.get(0).getVector());
        corners.add(loc1);
        corners.add(loc2);
        corners.add(loc3);
        corners.add(loc4);
    }

    private void computeCenter() {
        Location loc1 = block.getLocation();

        // This is kinda bad but ok
        if (map.get(changingCoord) == 1) {
            loc1.add(changingCoord.getVector());
        }
        loc1.add(remainingDirections.get(0).getVector().multiply(0.5));
        loc1.add(remainingDirections.get(1).getVector().multiply(0.5));
        center = loc1;
    }

    private void computeEdges() {
        for (int i = 0; i < corners.size(); i++) {
            Location loc1 = corners.get(i);
            Location loc2;
            if (i+1 >= corners.size()) {
                loc2 = corners.get(0);
            } else {
                loc2 = corners.get(i+1);
            }

            double distance = loc1.distance(loc2);
            double inbetween = 0.25;
            Vector vec1 = loc1.toVector();
            Vector vec2 = loc2.toVector();
            Vector vector = vec2.clone().subtract(vec1).normalize().multiply(inbetween);
            for (double covered = 0; covered < distance; vec1.add(vector)) {
                particleLocations.add(vec1.toLocation(block.getWorld()));
                covered += inbetween;
            }
        }
    }

    public abstract void run();
}
