package com.articreep.surfaces;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SurfaceApplier implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack i = new ItemStack(Material.PACKED_ICE);
            i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

            ItemMeta meta = i.getItemMeta();
            meta.setDisplayName("&5Icy Surface Applier");
            // temporary
            ArrayList<String> lore = new ArrayList<>();
            lore.add("&7Place this block on another block's surface");
            lore.add("&7to make it &bIcy&7.");
            meta.setLore(lore);

            i.setItemMeta(meta);
            p.getInventory().addItem(i);
            p.sendMessage("&4Right click on a block to use this item!");
            return true;

        }
        sender.sendMessage("&clog into the server nerd");
        return true;
    }
}
