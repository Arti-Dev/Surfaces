package com.articreep.surfaces.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Utils {

    // Nice little method to create a gui item with a custom name, and description
    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final org.bukkit.inventory.ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));


        item.setItemMeta(meta);

        return item;
    }

}
