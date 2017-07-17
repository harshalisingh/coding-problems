package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
	/* A sparse matrix can be represented as a sequence of rows, 
	 * each of which is a sequence of (column-number, value) pairs of the nonzero values in the row.
	 */
	public int[][] multiplySlow(int[][] A, int[][] B) {
	    int rA = A.length, cA = A[0].length, cB = B[0].length;
	    int[][] result = new int[rA][cB];

	    List[] indexA = new List[rA];
	    for(int i = 0; i < rA; i++) {
	        List<Integer> numsA = new ArrayList<>();
	        for(int j = 0; j < cB; j++) {
	            if(A[i][j] != 0){
	                numsA.add(j); 
	                numsA.add(A[i][j]);
	            }
	        }
	        indexA[i] = numsA;
	    }

	    for(int i = 0; i < rA; i++) {
	        List<Integer> numsA = indexA[i];
	        for(int p = 0; p < numsA.size() - 1; p += 2) {
	            int colA = numsA.get(p);
	            int valA = numsA.get(p + 1);
	            for(int j = 0; j < cB; j ++) {
	                int valB = B[colA][j];
	                result[i][j] += valA * valB;
	            }
	        }
	    }
	    return result;   
	}
	
	//Java solution without table (~70ms)
	// Just check for zeroes before multiplying
	public int[][] multiply(int[][] A, int[][] B) {
        int rA = A.length, cA = A[0].length;
        int rB = B.length, cB = B[0].length;
        int[][] C = new int[rA][cB];

        for(int i = 0; i < rA; i++) {
            for(int k = 0; k < cA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < cB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
}
