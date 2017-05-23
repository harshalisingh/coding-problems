package leetcode.Arrays;

/*
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
 * Time Complexity: O(M*N)
 * Auxiliary Space: O(1)
 */
public class BooleanMatrix {

	static void modifyMatrix(int matrix[][]){
		int r = matrix.length;
		int c = matrix[0].length;
		boolean rowFlag = false;
		boolean colFlag = false;

		//1st row
		for(int i=0;i<c;i++){
			if(matrix[0][i] == 1){
				rowFlag = true;
				break;
			}
		}

		//1st column
		for(int i=0;i<r;i++){
			if(matrix[i][0] == 1){
				colFlag = true;
				break;
			}
		}

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(matrix[i][j] == 1){
					matrix[0][j] = 1;
					matrix[i][0] = 1;
				}
			}
		}

		for(int i=1;i<r;i++){
			for(int j=1;j<c;j++){
				if(matrix[i][0] == 1 || matrix[0][j] == 1){
					matrix[i][j] = 1;
				}
			}
		}

		if(rowFlag){
			for(int i=0;i<c;i++)
				matrix[0][i] = 1;
		}

		if(colFlag){
			for(int i=0;i<r;i++){
				matrix[i][0] = 1;
			}
		}


	}

	/* A utility function to print a 2D matrix */
	static void printMatrix(int mat[][])
	{
		int i, j;
		for (i = 0; i < mat.length; i++)
		{
			for (j = 0; j < mat[0].length; j++)
			{
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args)
	{
		int mat[][] = new int[][]{ 
			{1, 0, 0, 1},
			{0, 0, 1, 0},
			{0, 0, 0, 0},
		};

		System.out.println("Input Matrix \n");
		printMatrix(mat);

		modifyMatrix(mat);

		System.out.println("Matrix after modification \n");
		printMatrix(mat);

	}

}
