package epi.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * There exist two distinct solutions to the 4-queens puzzle:

	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]

 */
public class NQueenProblemI {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> queenPlacement = new ArrayList<>();
		List<List<Integer>> colPlacement = new ArrayList<>();
		solveNQueens(n, 0, new ArrayList<Integer>(), colPlacement);
		for(List<Integer> placement: colPlacement){
			List<String> rowPlacement = new ArrayList<>();
			for(Integer col : placement){
				char[] row = new char[n];
				Arrays.fill(row, '.'); 
				row[col] = 'Q';
				rowPlacement.add(new String(row));
			}
			queenPlacement.add(rowPlacement);
		}
		return queenPlacement;
	}

	private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
		if(row == n){
			result.add(new ArrayList<>(colPlacement));
			return;
		} else {
			for(int col= 0; col < n; col++){
				colPlacement.add(col);
				if(isValid(colPlacement)){
					solveNQueens(n, row+1, colPlacement, result);
				}
				colPlacement.remove(colPlacement.size()-1);
			}
		}
	}

	private static boolean isValid(List<Integer> colPlacement) {
		int rowID = colPlacement.size()-1;
		for(int i = 0; i < rowID; i++){
			int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
			//same column or same diagonal
			if(diff == 0 || diff == rowID - i){
				return false;
			}
		}
		return true;
	}
}
