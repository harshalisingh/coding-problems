package leetcode.ArraySpecial;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.
 * Time complexity : O(n). We iterate over the given nums array of length n once only.
 * Space complexity : O(1). Constant extra space is used.
 */
public class SlidingWindowMaximumAverage {
	public double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for(int i = 0; i < k;i++)
			sum += nums[i];
		double res = sum;
		for(int i = k; i < nums.length; i++){
			sum += nums[i] - nums[i-k]; //add new number and subtract the number which falls outside the window
			res = Math.max(res,sum);
		}
		return res/k;
	}
}
