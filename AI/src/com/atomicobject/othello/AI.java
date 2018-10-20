package com.atomicobject.othello;

import java.util.Arrays;
import java.util.*;
import java.util.ListIterator;

public class AI {
	
	int maxRank = 0;
	int maxFlips = 0;
	
	ListIterator<int[]> moveList;

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		Move ourMove = new Move(1,1);
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (isLegal(r, c, state.getBoard(), state.getPlayer())>0){
					legalMoves.add(new Move(r,c));
					legalMoves.get(legalMoves.size()-1).setFlips(isLegal(r, c, state.getBoard(), state.getPlayer()));
				}
			}
		}
		
		for (Move m: legalMoves) {
			if (m.getRank() > maxRank) {
				maxRank = m.getRank();
			}
		}
		/*
		for (int i = 0; i < legalMoves.size(); i++) {
			if (legalMoves.get(i).getRank() < maxRank) {
				legalMoves.remove(i);
			}
		}
		*/
		
		for (Iterator<Move> iterator = legalMoves.iterator(); iterator.hasNext();) {
		    Move move = iterator.next();
		    if (move.getRank() < maxRank) {
		        iterator.remove();
		    }
		}
		
		
		for (Move m: legalMoves) {
			if (m.getFlips() > maxFlips) {
				maxFlips = m.getFlips();
			}
		}
		
		/*
		for (int i = 0; i < legalMoves.size(); i++) {
			if (legalMoves.get(i).getFlips() < maxFlips) {
				legalMoves.remove(i);
			}
		}	
		*/
		
		for (Iterator<Move> iterator = legalMoves.iterator(); iterator.hasNext();) {
		    Move move = iterator.next();
		    if (move.getFlips() < maxFlips) {
		        iterator.remove();
		    }
		}
		
		ourMove = legalMoves.get(0);
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
