package leetcode.Arrays;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * 
 */
public class ContainsDuplicateIII {
	/* Time Complexity: O(n min(n,k)), Space: O(1) */
	public boolean containsNearbyAlmostDuplicateBruteForce(int[] nums, int k, int t) {
	    for (int i = 0; i < nums.length; ++i) {
	        for (int j = Math.max(i - k, 0); j < i; ++j) {
	            if (Math.abs(nums[i] - nums[j]) <= t) return true;
	        }
	    }
	    return false;
	}
	// Time limit exceeded.
}
