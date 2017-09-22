package leetcode.ArraySpecial;

/** Maximum Contiguous Subsequence Sum Problem
 * Largest Sum Contiguous subarray (Kadane's algorithm)
 * https://leetcode.com/problems/maximum-subarray/#/description
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * DP: O(N) Time, O(1) Space
 */
public class MaximumSumSubArray {

	public int maxSubArray(int[] A) {
		int n = A.length;
		int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
		dp[0] = A[0];
		int max = dp[0];

		for(int i = 1; i < n; i++){
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

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
