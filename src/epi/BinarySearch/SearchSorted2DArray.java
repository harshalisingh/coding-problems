package epi.BinarySearch;

import java.util.List;

public class SearchSorted2DArray {
	
	public static boolean matrixSearch(List<List<Integer>> A, int x){
		
		int row = 0, col = A.get(0).size() - 1; 
		
		while(row < A.size() && col >= 0){
			
			if(A.get(row).get(row).equals(x)){
				return true;
			} else if(x > A.get(row).get(col)){
				++row; //Increase row
			} else {
				--col; //Decrease column
			}
		}
		
		return false;
	}

}
