package leetcode.DP;

/*
 * http://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-in-2d-matrix-with-obstructions-in-it/
 */
public class CountAllPathsWithObstruction {

	public int count(int [][] arrA, int row, int col){
		//base case
		//check if last row OR column is reached since after that only one path
		if(row==arrA.length-1 && col==arrA.length-1){
			return 1;
		}
		int left =0;
		int down = 0;
		if(row!=arrA.length-1 && arrA[row+1][col]!=-1){
			left = count(arrA, row+1, col);
		}
		if(col!=arrA.length-1 && arrA[row][col+1]!=-1){
			down = count(arrA, row, col+1);
		}
		return left + down;
	}

	public int countDP(int [][] arrA){
		int result [][] = arrA;

		for (int i = 1; i <result.length ; i++) {
			for (int j = 1; j <result.length ; j++) {
				if(result[i][j]!=-1){
					result[i][j]=0;
					if(result[i-1][j]>0)
						result[i][j]+=result[i-1][j];
					if(result[i][j-1]>0)
						result[i][j]+=result[i][j-1];
				}
			}
		}
		
		return result[arrA.length-1][arrA.length-1];
	}

	public static void main(String[] args) {
		int arrA [][] = {{1,1,1},{1,-1,1},{1,1,1}};
		CountAllPathsWithObstruction noOfPaths = new CountAllPathsWithObstruction();
		System.out.println("No Of Path (Recursion):- " +noOfPaths.count(arrA,0,0));
		System.out.println("No Of Path (DP):- " +noOfPaths.countDP(arrA));
	}
}