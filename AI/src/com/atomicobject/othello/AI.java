package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class AI {
	
	ListIterator<int[]> moveList;

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		int[] move = new int[2];
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				System.out.println(r);
				System.out.println(c);
				
				if (isLegal(r, c, state.getBoard(), state.getPlayer())){
					move[0] = r;
					move[1] = c;
					return move;
				}
			}
		}
		System.out.println("no legal move found");
		return move;
		
	}
	
	public boolean isLegal (int row, int column, int[][] board, int player) {
		int r = row;
		int c = column;
		
		System.out.println("starting check");
		
		if (board[r][c]==0) {
			int checkRow;
			int checkCol;
			boolean end;
			int position;
			
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					System.out.println("first for loop");
					checkRow = r + y;
					checkCol = c + x;
					end = false;
					
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
						checkRow += y;
						checkCol += x;
						
						System.out.println("check 2");
						
						if (checkRow > 7 || checkRow < 0 || checkCol > 7 || checkCol < 0) {
							break direction;
						}
						
						position = board[checkRow][checkCol];
						
						if (position == player) {
							return true;
							
						}
						
						else if (position == 0) {
							end = true;
						}
					}
					
				}
			}
		}
		return false;
	}
}
