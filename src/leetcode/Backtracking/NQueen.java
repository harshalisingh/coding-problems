package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import epi.Recursion.NQueenProblem;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 */
public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();

		boolean[] cols = new boolean[n];     // columns   |
		boolean[] d1 = new boolean[2 * n];   // diagonals \
		boolean[] d2 = new boolean[2 * n];   // diagonals /

		backtracking(result, new ArrayList<String>(), 0, cols, d1, d2, n);
		return result;
	}

	private void backtracking(List<List<String>> result, List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n){
		if (row == n) 
			result.add(new ArrayList<String>(board));


		for (int col = 0; col < n; col++){
			int id1 = col - row + n;
			int id2 = col + row;

			//A queen already exists in this col, diagonal1 or diagonal2
			if(cols[col] || d1[id1] || d2[id2]) continue;

			char[] r = new char[n];
			Arrays.fill(r, '.');
			r[col] = 'Q';
			board.add(new String(r));
			
			//set the current col, d1 and d2 to true
			cols[col] = true;
			d1[id1] = true;
			d2[id2] = true;
			
			//move to next row
			backtracking(result, board, row+1, cols, d1, d2, n);
			
			//remove this placement
			board.remove(board.size()-1);
			cols[col] = false;
			d1[id1] = false;
			d2[id2] = false;

		}
	}
	public static void main(String[] args){
		NQueen nq = new NQueen();
		for(List<String> rows : nq.solveNQueens(4)){
			System.out.println(rows);
		}
	}
}
