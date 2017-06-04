package leetcode.DP;

public class CountAllPathsFromTopLeftToBottomRight {

	public int count(int [][] arrA, int row, int col){
		//base case
		//check if last row OR column is reached since after that only one path
		//is possible to reach to the bottom right corner.
		if(row==arrA.length-1 || col==arrA.length-1){
			return 1;
		}
		return count(arrA, row+1, col) + count(arrA, row, col+1);
	}

	//Time Complexity: O(mn).
	public int countDP(int [][] arrA){
		int result [][] = new int[arrA.length][arrA.length];

		//base case: if we have one cell then there is only one way
		result[0][0] = 1;

		//no of paths to reach in any cell in first row = 1
		for (int i = 0; i < result.length ; i++) {
			result[0][i] = 1;
		}

		//no of paths to reach in any cell in first col = 1
		for (int i = 0; i < result.length ; i++) {
			result[i][0] = 1;
		}

		for (int i = 1; i < result.length ; i++) {
			for (int j = 1; j < result.length ; j++) {
				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}

		return result[arrA.length-1][arrA.length-1];
	}
	
	public static int minCostPath(int[][] A) {
		int[][] solution = new int[A.length][A.length];

		solution[0][0] = A[0][0];
		
		// fill the first row
		for (int i = 1; i < A.length; i++) {
			solution[0][i] = A[0][i] + solution[0][i - 1];
		}

		// fill the first column
		for (int i = 1; i < A.length; i++) {
			solution[i][0] = A[i][0] + solution[i - 1][0];
		}

		// path will be either from top or left, choose which ever is minimum
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < A.length; j++) {
				solution[i][j] = A[i][j]
						+ Math.min(solution[i - 1][j], solution[i][j - 1]);
			}
		}
		return solution[A.length - 1][A.length - 1];
	}


	public static void main(String[] args) {
		int arrA [][] = {{1,1,1},{1,1,1},{1,1,1}};
		CountAllPathsFromTopLeftToBottomRight noOfPaths = new CountAllPathsFromTopLeftToBottomRight();
		System.out.println("No Of Path (Recursion):- " +noOfPaths.count(arrA,0,0));
		System.out.println("No Of Path (DP):- " +noOfPaths.countDP(arrA));
	}
}
