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
}
