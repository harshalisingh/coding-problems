package leetcode.Arrays.MissingOrDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * https://leetcode.com/problems/contains-duplicate-ii/#/description
 */
class ContainsDuplicateII {
	/*
	 * Time Complexity: O(n min(n,k)), Space: O(1)
	 */
	public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
	    for (int i = 0; i < nums.length; ++i) {
	        for (int j = Math.max(i - k, 0); j < i; ++j) {
	            if (nums[i] == nums[j]) return true;
	        }
	    }
	    return false;
	}
	// Time Limit Exceeded.
	
	/*
	 * Time complexity : O(n). We do n operations of search, delete and insert, each with constant time complexity.
	 * Space complexity : O(min(n,k))
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	    Set<Integer> set = new HashSet<>();
	    for (int i = 0; i < nums.length; ++i) {
	        if (set.contains(nums[i])) return true;
	        set.add(nums[i]);
	        if (set.size() > k) {          //if set contains more than k elements, 
	            set.remove(nums[i - k]);   //start removing elements which k distance apart from i
	        }
	    }
	    return false;
	}
}
