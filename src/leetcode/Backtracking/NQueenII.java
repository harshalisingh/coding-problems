package leetcode.Backtracking;

import java.util.List;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueenII {
	int count = 0;
	public int totalNQueens(int n) {
		boolean[] cols = new boolean[n];     // columns   |
		boolean[] d1 = new boolean[2 * n];   // diagonals \
		boolean[] d2 = new boolean[2 * n];   // diagonals /
		backtracking(0, cols, d1, d2, n);
		return count;
	}

	public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
		if(row == n) 
			count++;

		for(int col = 0; col < n; col++) {
			int id1 = col - row + n;
			int id2 = col + row;
			if(cols[col] || d1[id1] || d2[id2]) continue;

			//set the current col, d1 and d2 to true
			cols[col] = true; d1[id1] = true; d2[id2] = true;

			//move to next row
			backtracking(row + 1, cols, d1, d2, n);

			//remove this placement
			cols[col] = false; d1[id1] = false; d2[id2] = false;
		}
	}
	public static void main(String[] args){
		NQueenII nq2 = new NQueenII();
		System.out.println(nq2.totalNQueens(4));
	}
}
