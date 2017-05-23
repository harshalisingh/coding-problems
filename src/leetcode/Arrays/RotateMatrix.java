package leetcode.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/#/description
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
        int len = matrix.length;
        
        //Transpose
        for(int i = 0; i < len / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[len - 1 - i];
            matrix[len - 1 - i] = tmp;
        }
        
        //Flip the rows
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
