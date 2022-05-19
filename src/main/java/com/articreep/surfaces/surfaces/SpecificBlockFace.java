package com.articreep.surfaces.surfaces;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class SpecificBlockFace {
  
    private Block block;
    private BlockFace face;
  
    public SpecificBlockFace(Block block, BlockFace face) {
        this.block = block;
        this.face = face;
    }
  
    @Override
    public boolean equals(Object o) {
        if (o instanceof SpecificBlockFace) {
            return (block.equals(((SpecificBlockFace) o).getBlock()) && face.equals(((SpecificBlockFace) o).getFace()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return block.hashCode()+31*face.hashCode();
    }
  
    public Block getBlock() {
    return block;
  }
  
    public BlockFace getFace() {
    return face;
  }
}
