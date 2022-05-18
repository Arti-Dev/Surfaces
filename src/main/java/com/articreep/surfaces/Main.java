package com.articreep.surfaces;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main main = null;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ToolListeners(), this);
        getCommand("surfaceapplier").setExecutor(new SurfaceApplier());
        main = this;
    }

    @Override
    public void onDisable() {
        getLogger().fine("bye-bye");
    }

    public static Main getPlugin() {
        return main;
    }
}
