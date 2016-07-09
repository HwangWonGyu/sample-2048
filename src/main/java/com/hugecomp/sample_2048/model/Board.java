package com.hugecomp.sample_2048.model;

public class Board {
	
	private int value; // value that printed to console
	
	public Board() {
		
	}
	
	public Board(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static Board createRandomValueToRandomPosition(int... values) {
		if (values == null) {
			throw new IllegalArgumentException("values can't be null");
		}

		int factor = ((int)(Math.random() * 10)) % 2;
		int value = (factor == 0 ? 2 : 4);
		
		Board block = new Board();
		block.setValue(value);
		
		return block;
	}
}
