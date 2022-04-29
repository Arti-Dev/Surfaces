package com.articreep.surfaces.surfaces;

import com.articreep.surfaces.utils.Directions;
import org.bukkit.util.Vector;

public enum SurfaceDirection {
    EAST(Directions.X), UP(Directions.Y), SOUTH(Directions.Z), WEST(Directions.NONE),
    DOWN(Directions.NONE), NORTH(Directions.NONE);

    Directions direction;
    SurfaceDirection(Directions direction) {
        this.direction = direction;
    }

    public Directions getDirection() {
        return direction;
    }
}
