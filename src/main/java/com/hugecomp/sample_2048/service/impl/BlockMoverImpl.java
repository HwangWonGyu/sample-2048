package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMover;

public class BlockMoverImpl implements BlockMover {
	
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
	
	private void moveBlocksVerticallyInAColumn(Board[][] blocks, int columnIndex, int start, int end, int interval) {
		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			Integer emptyBlockRowIndex = findEmptyBlockIndexInAColumn(blocks, columnIndex, start, end, interval);
			if (emptyBlockRowIndex == null) {
				return;
			}

			Integer valuableBlockRowIndex = findValuableBlockIndexInAColumn(blocks, columnIndex, emptyBlockRowIndex + interval, end, interval);
			if (valuableBlockRowIndex == null) {
				return;
			}

			swapBlocksInAColumn(blocks, columnIndex, emptyBlockRowIndex, valuableBlockRowIndex);
		}
	}
	
	private Integer findEmptyBlockIndexInAColumn(Board[][] blocks, int columnIndex, int start, int end, int interval) {
		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			if (blocks[rowIndex][columnIndex] == null) {
				return rowIndex;
			}
		}

		return null;
	}
	
	private Integer findValuableBlockIndexInAColumn(Board[][] blocks, int columnIndex, int start, int end, int interval) {
		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			if (blocks[rowIndex][columnIndex] != null) {
				return rowIndex;
			}
		}

		return null;
	}
	
	private void swapBlocksInAColumn(Board[][] blocks, int columnIndex, Integer rowIndex1, Integer rowIndex2) {
		Board tempBlock = blocks[rowIndex1][columnIndex];
		blocks[rowIndex1][columnIndex] = blocks[rowIndex2][columnIndex];
		blocks[rowIndex2][columnIndex] = tempBlock;
	}
	
	private void moveBlocksHorizontally(Board[][] blocks, Direction direction) {
		boolean isLeft = (direction == Direction.LEFT);

		int start = isLeft ? 0 : Table.SIZE - 1;
		int end = isLeft ? Table.SIZE : -1;
		int interval = isLeft ? 1 : -1;

		for (Board[] block : blocks) {
			moveBlocksHorizontallyInARow(block, start, end, interval);
		}
	}
	
	private void moveBlocksHorizontallyInARow(Board[] blocks, int start, int end, int interval) {
		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {

			Integer emptyBlockColumnIndex = findEmptyBlockIndexInARow(blocks, columnIndex, end, interval);

			if (emptyBlockColumnIndex == null) {
				return;
			}

			Integer valuableBlockColumnIndex = findValuableBlockIndexInARow(blocks, emptyBlockColumnIndex + interval, end, interval);

			if (valuableBlockColumnIndex == null) {
				return;
			}

			swapBlocksInARow(blocks, emptyBlockColumnIndex, valuableBlockColumnIndex);
		}
	}
	
	private Integer findEmptyBlockIndexInARow(Board[] blocks, int start, int end, int interval) {
		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {
			if (blocks[columnIndex] == null) {
				return columnIndex;
			}
		}

		return null;
	}
	
	private Integer findValuableBlockIndexInARow(Board[] blocks, int start, int end, int interval) {
		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {

			if (blocks[columnIndex] != null) {
				return columnIndex;
			}
		}

		return null;
	}
	
	private void swapBlocksInARow(Board[] blocks, Integer columnIndex1, Integer columnIndex2) {
		Board tempBlock = blocks[columnIndex1];
		blocks[columnIndex1] = blocks[columnIndex2];
		blocks[columnIndex2] = tempBlock;
	}
}
