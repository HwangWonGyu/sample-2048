package com.hugecomp.sample_2048.model;

public class Table {
	public static final int SIZE = 4;

	private Board[][] blocks = new Board[SIZE][SIZE];

	public void setBlocks(Board[][] blocks) {
		this.blocks = blocks;
	}
	
	public Board[][] getBlocks() {
		return this.blocks;
	}
}
