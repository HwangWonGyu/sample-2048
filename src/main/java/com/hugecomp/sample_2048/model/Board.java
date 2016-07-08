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
}
