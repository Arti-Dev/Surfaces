package com.articreep.surfaces;

import com.articreep.surfaces.surfaces.SlipperySurface;
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
        if (i.getItemMeta().getDisplayName().equals(ItemNames.ICE_TOOL.getName())) {
            p.playSound(p, Sound.BLOCK_POWDER_SNOW_PLACE, 1, 1);
            e.setCancelled(true);
            BlockFace face = null;
            for (BlockFace testFace : BlockFace.values()) {
                if (e.getBlockAgainst().getRelative(testFace).equals(e.getBlock())) {
                    if (!testFace.isCartesian()) continue;
                    face = testFace;
                    break;
                }
            }
            SlipperySurface obj = new SlipperySurface(e.getBlockAgainst(), face);
            obj.run();
            p.sendMessage(ChatColor.GREEN + "Surface placed");
        }
    }
}
