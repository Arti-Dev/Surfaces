package com.articreep.surfaces.utils;

import org.bukkit.util.Vector;

public enum Directions {
    X(new Vector(1, 0, 0)), Y(new Vector(0, 1, 0)), Z(new Vector(0, 0, 1)), NONE(new Vector(0, 0, 0));

    Vector vector;
    Directions(Vector vector) {
        this.vector = vector;
    }

    public Vector getVector() {
        return vector;
    }
}
