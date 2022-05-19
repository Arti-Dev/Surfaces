package com.articreep.surfaces;

import com.articreep.surfaces.utils.Utils;
import org.bukkit.ChatColor;
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
    private static String invalidItem = ChatColor.RED + "Acceptable values: icy, sticky, remove";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length != 1) {
                p.sendMessage(invalidItem);
                return true;
            }
            //TODO tabcomplete moment
            if (args[0].equalsIgnoreCase("icy")) {

                ItemStack i = Utils.createGuiItem(Material.PACKED_ICE, ChatColor.LIGHT_PURPLE + "Icy Surface Applier",
                        ChatColor.GRAY + "Place this block on another block's surface",
                        ChatColor.GRAY + "to make it " + ChatColor.AQUA + "Icy" + ChatColor.GRAY + ".");

                i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                p.getInventory().addItem(i);
            } else if (args[0].equalsIgnoreCase("sticky")) {

                ItemStack i = Utils.createGuiItem(Material.SLIME_BLOCK, ChatColor.LIGHT_PURPLE + "Sticky Surface Applier",
                        ChatColor.GRAY + "Place this block on another block's surface",
                        ChatColor.GRAY + "to make it " + ChatColor.GREEN + "Sticky" + ChatColor.GRAY + ".");

                i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                p.getInventory().addItem(i);
            } else if (args[0].equalsIgnoreCase("remove")) {
                ItemStack i = Utils.createGuiItem(Material.SPONGE, ChatColor.LIGHT_PURPLE + "Surface Remover",
                        ChatColor.GRAY + "Place this block on another block's surface",
                        ChatColor.GRAY + "to clear any existing surface type.");

                i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                p.getInventory().addItem(i);
            } else {
                p.sendMessage(invalidItem);
                return true;
            }
            return true;

        }
        sender.sendMessage("&clog into the server nerd");
        return true;
    }
}
