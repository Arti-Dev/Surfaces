package com.articreep.surfaces.surfaces;

public class SpecificBlockFace {
  
  private Block block;
  private BlockFace face;
  
  public SpecificBlockFace(Block block, BlockFace face) {
    this.block = block;
    this.face = face;
  }
  
  @Override
  public equals(Object o) {
    if (o instanceof SpecificBlockFace) {
      return (block.equals(o.getBlock) && face.equals(o.getFace));
    }
    return false;
  }
  
  public Block getBlock() {
    return block;
  }
  
  public BlockFace getFace() {
    return face;
  }
}
