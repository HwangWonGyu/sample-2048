package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMover;

public class BlockMoverImpl implements BlockMover {
	
	@Override
	public void moveBlocks(Board[][] blocks, Direction direction) {
		switch (direction) {
			case UP:
			case DOWN:
				moveBlocksVertically(blocks, direction);
				break;
			case LEFT:
			case RIGHT:
				moveBlocksHorizontally(blocks, direction);
				break;
			default :
				throw new IllegalArgumentException(direction.name() + " is not valid direction");
		}
	}
}
