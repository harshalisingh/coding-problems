package leetcode.Arrays;

/*
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, 
 * we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * 
 */

public class RotateFunction {
	public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }
        
        int sum = 0, iteration = 0, len = A.length;
        
        for(int i=0; i<len; i++){
            sum += A[i];
            iteration += (A[i] * i);
        }
        
        int max = iteration;
        for(int j=1; j<len; j++){
            // for next iteration lets remove one entry value of each entry and the prev 0 * k
            iteration = iteration - sum + A[j-1]*len;
            max = Math.max(max, iteration);
        }
        
        return max;
    }
}
