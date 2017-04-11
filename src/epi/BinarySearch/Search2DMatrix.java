package epi.BinarySearch;

/*
 * https://leetcode.com/problems/search-a-2d-matrix/#/description
 * https://leetcode.com/problems/search-a-2d-matrix-ii/#/description
 */
public class Search2DMatrix {	
	
	/*
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the last integer of the previous row.
	 */ 
	public boolean search2DMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
                if (target == matrix[row][col]) {
                    return true;
                } else if (target < matrix[row][col]) {
                    col--;
                } else {
                    row++;
                }
            }       
        return false;
    }
	
	/*
	 * Integers in each row are sorted in ascending from left to right.
	 * Integers in each column are sorted in ascending from top to bottom.
	 */
	public boolean search2DMatrixII(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length-1 && col >= 0) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		Search2DMatrix search = new Search2DMatrix();
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		System.out.println(search.search2DMatrix(matrix, 16));
	}
}
