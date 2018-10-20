package com.atomicobject.othello;

public class Move {
	int[] coord = new int[2];
	int flips;


	public Move (int row, int col) {
		coord[0] = row;
		coord[1] = col;
		flips = 0;
	}
	
	public void setFlips(int flips) {
		this.flips = flips;
	}
	
	public int getFlips() {
		return flips;
	}
	
	public int[] getCoord() {
		return coord;
	}
}