package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.Table;
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
	
	private void moveBlocksVertically(Board[][] blocks, Direction direction) {
		boolean isUp = (direction == Direction.UP);

		int start = isUp ? 0 : Table.SIZE - 1;
		int end = isUp ? Table.SIZE : -1;
		int interval = isUp ? 1 : -1;

		for (int columnIndex = 0; columnIndex < Table.SIZE; columnIndex++) {
			moveBlocksVerticallyInAColumn(blocks, columnIndex, start, end, interval);
		}
	}
}
