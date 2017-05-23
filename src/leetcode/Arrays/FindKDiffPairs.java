package leetcode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 */
public class FindKDiffPairs {

	//Using HashMap
	public int findPairsUsingHashMap(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k == 0) return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int n : nums){
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(k == 0){
				//count how many elements in the array that appear more than twice.
				if(entry.getValue() >= 2)
					count++;
			} else {
				if(map.containsKey(entry.getKey() + k))
					count++;
			}
		}
		return count;
	}
	
	//The code runs in O(n log n) time, using O(1) space.
	public int findPairsUsingTwoPointer(int[] nums, int k){
		int count = 0;
		Arrays.sort(nums);
		for(int i = 0, j = 0; i < nums.length; i++){
			for(j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++);
			if(j < nums.length && (long) nums[j] - nums[i] == k) count++;
			while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
		}
		return count;
	}
}
