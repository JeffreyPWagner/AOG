package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class AI {
	
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
	
	ListIterator<int[]> moveList;

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		Move ourMove = new Move(1,1);
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				System.out.println(r);
				System.out.println(c);
				
				if (isLegal(r, c, state.getBoard(), state.getPlayer())>0){
					if (ranks[r][c] >= ranks[ourMove.getCoord()[0]][ourMove.getCoord()[1]]) {
					ourMove = new Move(r,c);
					}
				}
			}
		}
		return ourMove.getCoord();
	}
	
	public int isLegal (int row, int column, int[][] board, int player) {
		int r = row;
		int c = column;
		int flips = 0;
		
		System.out.println("starting check");
		
		if (board[r][c]==0) {
			int checkRow;
			int checkCol;
			boolean end;
			int position;
			int potFlips;
			
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					System.out.println("first for loop");
					checkRow = r + y;
					checkCol = c + x;
					end = false;
					potFlips = 0;
					
					if (checkRow > 7 || checkRow < 0 || checkCol > 7 || checkCol < 0) {
						continue;
					}
					
					position = board[checkRow][checkCol];
					
					System.out.println(checkRow);
					System.out.println(checkCol);
					System.out.println(position);
					
					if (position == 0 || position == player) {
						continue;
					}
					
					System.out.println("check 1");
					
					direction: while (!end) {
						potFlips += 1;
						checkRow += y;
						checkCol += x;
						
						System.out.println("check 2");
						
						if (checkRow > 7 || checkRow < 0 || checkCol > 7 || checkCol < 0) {
							break direction;
						}
						
						position = board[checkRow][checkCol];
						
						if (position == player) {
							flips += potFlips;
							end = true;
							
							
						}
						
						else if (position == 0) {
							end = true;
						}
					}
					
				}
			}
		}
		System.out.println("flips" + flips);
		return flips;
	}
}
