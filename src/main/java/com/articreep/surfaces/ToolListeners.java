package com.articreep.surfaces;

import com.articreep.surfaces.surfaces.*;
import com.articreep.surfaces.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class ToolListeners implements Listener {

    @EventHandler
    public void onToolUse(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getInventory().getItemInMainHand();
        if (!i.hasItemMeta()) return;
        Surface surface = null;
        BlockFace face = null;
        if (i.getItemMeta().getDisplayName().equals(ItemNames.ICY_TOOL.getName())) {
            p.playSound(p, Sound.BLOCK_POWDER_SNOW_PLACE, 1, 1);
            e.setCancelled(true);
            face = Utils.computeBlockFace(e.getBlockAgainst(), e.getBlock());
            surface = new SlipperySurface(e.getBlockAgainst(), face);
        } else if (i.getItemMeta().getDisplayName().equals(ItemNames.STICKY_TOOL.getName())) {
            p.playSound(p, Sound.BLOCK_SLIME_BLOCK_PLACE, 1, 1);
            e.setCancelled(true);
            face = Utils.computeBlockFace(e.getBlockAgainst(), e.getBlock());
            surface = new StickySurface(e.getBlockAgainst(), face);
        } else if (i.getItemMeta().getDisplayName().equals(ItemNames.REMOVE_TOOL.getName())) {
            p.playSound(p, Sound.BLOCK_SMOKER_SMOKE, 1, 1);
            e.setCancelled(true);
            face = Utils.computeBlockFace(e.getBlockAgainst(), e.getBlock());
            if (SurfaceManager.removeSurface(new SpecificBlockFace(e.getBlockAgainst(), face))) {
                p.sendMessage(ChatColor.GREEN + "Surface removed");

            } else {
                p.sendMessage(ChatColor.RED + "There isn't a surface here!");
            }
            return;
        } else {
            return;
        }
        if (SurfaceManager.addSurface(new SpecificBlockFace(e.getBlockAgainst(), face), surface)) {
            p.sendMessage(ChatColor.GREEN + "Surface placed");
        } else {
            p.sendMessage(ChatColor.RED + "Something went wrong! Does this surface already have the same type?");
        }


    }
}
