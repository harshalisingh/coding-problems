package leetcode.ArraySpecial;

/*
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 * such that the integers in the subsequence are sorted in increasing order. 
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 
 * Variation of Longest Increasing Subsequence
 */
public class MaximumSumIncreasingSubsequence {
	public static int largestSumIncreasingSubseq(int[] nums){
		// Base case
		if(nums.length <= 1) return nums[0];
		
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			dp[i] = nums[i];
		}

		int maxSum = Integer.MIN_VALUE;
		for(int i = 1; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
					maxSum = Math.max(maxSum, dp[i]);
				}
			}
		}
		return maxSum;
	}
	
	/* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing "+
                           " subsequence is "+
       largestSumIncreasingSubseq(arr) );
    }
}
