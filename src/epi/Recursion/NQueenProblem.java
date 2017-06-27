package epi.Recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * Return the N Queens Column Placement for n*n board.
 * e.g. n = 4
 * result = [[1, 3, 0, 2], [2, 0, 3, 1]]
 */
public class NQueenProblem {
	public static List<List<Integer>> nQueens(int n){
		List<List<Integer>> result = new ArrayList<>();
		solveNQueens(n, 0, new ArrayList<Integer>(), result);
		return result;
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
			//d1 = col - row + n, d2 = col + row;
			if(diff == 0 || diff == rowID - i){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		NQueenProblem nqp = new NQueenProblem();
		for(List cols : nqp.nQueens(4)){
			System.out.println(cols.toString());
		}
	}
}
