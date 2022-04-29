package com.articreep.surfaces;

import com.articreep.surfaces.surfaces.SlipperySurface;
import com.articreep.surfaces.surfaces.Surface;
import com.articreep.surfaces.surfaces.SurfaceDirection;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class ToolListeners implements Listener {

    public void onToolUse(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getInventory().getItemInMainHand();
        if (!i.hasItemMeta()) return;
        if (i.getItemMeta().getDisplayName().equals(ItemNames.ICE_TOOL.getName())) {
            p.playSound(p, Sound.BLOCK_POWDER_SNOW_PLACE, 1, 1);
            p.sendMessage("&2Surface placed");
        }
    }
}
