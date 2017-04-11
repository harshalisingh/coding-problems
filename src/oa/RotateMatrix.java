package oa;

public class RotateMatrix {
	public int[][] rotate(int[][] matrix) {
		if (matrix == null || matrix.length < 2) {
			return matrix;
		}
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res[j][i] = matrix[i][j]; // counterclockwise
				// res[n - 1 - j][n - 1 - i] = matrix[i][j] // clockwise
			}
		}

		int n = res.length;
		for (int i = 0; i < res.length / 2; i++) {
			for (int j = 0; j < res[0].length; j++) {
				int temp = res[i][j];
				res[i][j] = res[n - 1 - i][j];
				res[n - 1 - i][j] = temp;
			}
		}

		return res;
	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateMatrix test = new RotateMatrix();
		int[][] matrix = new int[3][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = i * 3 + j;
			}
		}
		test.printMatrix(matrix);
		int[][] res = test.rotate(matrix);
		test.printMatrix(res);
	}
}


