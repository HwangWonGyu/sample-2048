package com.hugecomp.sample_2048.model;

import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMerger;
import com.hugecomp.sample_2048.service.impl.BlockMergerImpl;

public class Table {
	public static final String NULL_BLOCK_EXPRESSION = "*";
	public static final int SIZE = 4;
	private Board[][] blocks = new Board[SIZE][SIZE];
	private int score = 0;
	
	public void setBlocks(Board[][] blocks) {
		this.blocks = blocks;
	}
	
	public Board[][] getBlocks() {
		return this.blocks;
	}
	
	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return this.score;
	}
	
	public Board createBlockToEmptySpace() {

		Point emptyPoint = getEmptyPointInTable();
		Board block = Board.createRandomValueToRandomPosition(2, 4);
		blocks[emptyPoint.getY()][emptyPoint.getX()] = block;

		return block;
	}
	
	private Point getEmptyPointInTable() {
		int randomFactor = 100;

		while(true) {
			int row = ((int)(Math.random() * randomFactor)) % SIZE;
			int col = ((int)(Math.random() * randomFactor)) % SIZE;

			if (this.blocks[row][col] == null) {
				return new Point(col, row);
			}
		}
	}
	
	public boolean isContinuable() {
		return !isFull() || hasBlocksAbleToMerge();
	}

	private boolean hasBlocksAbleToMerge() {
		BlockMerger blockMerger = new BlockMergerImpl();

		for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
			for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
				for (Direction direction : Direction.values()) {
					if (blockMerger.isAbleToMerge(this.blocks, rowIndex, columnIndex, direction)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean isFull() {
		for (Board[] blockArray : this.blocks) {
			for (Board block : blockArray) {
				if (block == null) {
					return false;
				}
			}
		}

		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				sb.append(blocks[i][j] == null ? NULL_BLOCK_EXPRESSION : blocks[i][j].getValue());

				if(blocks[i][j] != null) { // 자리수에 알맞은 간격
					if(0 <= blocks[i][j].getValue() && blocks[i][j].getValue() < 10)
						sb.append("    ");
					else if(10 <= blocks[i][j].getValue() && blocks[i][j].getValue() < 100)
						sb.append("   ");
					else if(100 <= blocks[i][j].getValue() && blocks[i][j].getValue() < 1000)
						sb.append("  ");
					else
						sb.append(" ");
				}
				else
					sb.append("    ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
