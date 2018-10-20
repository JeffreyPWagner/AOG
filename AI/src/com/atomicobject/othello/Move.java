package com.atomicobject.othello;

public class Move {
	int[] coord = new int[2];
	int flips;
	int rank;
	int[][] ranks = {
			{7,2,5,4,4,5,2,7},
			{2,1,3,3,3,3,1,2},
			{5,3,6,5,5,6,3,5},
			{4,3,5,6,6,5,3,4},
			{4,3,5,6,6,5,3,4},
			{5,3,6,5,5,6,3,5},
			{2,1,3,3,3,3,1,2},
			{7,2,5,4,4,5,2,7}
	};

	public Move (int row, int col) {
		coord[0] = row;
		coord[1] = col;
		flips = 0;
		rank = ranks[row][col];
	}
	
	public void setFlips(int flips) {
		this.flips = flips;
	}
	
	public int getFlips() {
		return flips;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int[] getCoord() {
		return coord;
	}
}