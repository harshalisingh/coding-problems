package leetcode.ArraySpecial;

/** 
 * Largest Sum Contiguous subarray (Kadane's algorithm)
 * https://leetcode.com/problems/maximum-subarray/#/description
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * DP: O(N) Time, O(1) Space
 */
public class MaximumSumSubArray {

	public int maxSumSubArray(int[] A) {
		int maxSumEndingHere=A[0], maxSumSoFar=A[0];
		for (int i = 1;i < A.length; ++i){
			maxSumEndingHere= Math.max(A[i], maxSumEndingHere + A[i]);
			maxSumSoFar=Math.max(maxSumSoFar, maxSumEndingHere);	
		}
		return maxSumSoFar;
	}
	
	public static void main(String[] args){
		MaximumSumSubArray mss = new MaximumSumSubArray();
		int[] input = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(mss.maxSumSubArray(input));
	}
}
