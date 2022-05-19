package com.articreep.surfaces;

import org.bukkit.ChatColor;

public enum ItemNames {

    ICY_TOOL(ChatColor.LIGHT_PURPLE + "Icy Surface Applier"), STICKY_TOOL(ChatColor.LIGHT_PURPLE + "Sticky Surface Applier"),
    REMOVE_TOOL(ChatColor.LIGHT_PURPLE + "Surface Remover");

    private final String name;

    ItemNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
