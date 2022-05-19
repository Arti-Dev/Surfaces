package com.articreep.surfaces.surfaces;

import java.util.HashMap;

public class SurfaceManager {
    private SurfaceManager() {}

    private static HashMap<SpecificBlockFace, Surface> storage = new HashMap<>();

    public static boolean addSurface(SpecificBlockFace face, Surface surface) {
        // Check if surface already exists
        if (storage.containsKey(face)) {
            // Check if it's the same type of surface
            if (storage.get(face).getClass() == surface.getClass()) {
                return false;
            }
            // If not just stop and remove
            storage.get(face).stopParticles();
            storage.remove(face);
        }
        storage.put(face, surface);
        surface.displayParticles();
        return true;
    }

    public static boolean removeSurface(SpecificBlockFace face) {
        if (storage.containsKey(face)) {
            storage.get(face).stopParticles();
            storage.remove(face);
            return true;
        }
        return false;
    }
}
