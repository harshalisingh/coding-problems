package leetcode.ArraySpecial;

import java.util.Arrays;

/*
 * Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing subsequence is [2, 3, 7, 101], 
 * therefore the length is 4.
 * https://leetcode.com/problems/longest-increasing-subsequence/#/description
 * 
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		// Base case
		if(nums == null) return 0;
		if(nums.length <= 1) return nums.length;

		// This will be our array to track longest sequence length
		// Fill each position with value 1 in the array
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);

		int maxLen = Integer.MIN_VALUE;
		// Mark one pointer at i. For each i, start from j=0.
		for(int i=1; i < nums.length; i++) {
			for(int j=0; j < i; j++) {

				// It means next number contributes to increasing sequence.
				if(nums[i] > nums[j]) {

					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
		}
		return maxLen;
	}

	public static void main(String[] args){
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int length = lis.lengthOfLIS(nums);
		System.out.println(length);
	}
}
