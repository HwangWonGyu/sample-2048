package com.hugecomp.sample_2048.model;

public class Table {
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
}
