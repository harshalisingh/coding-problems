package leetcode.Arrays.MissingOrDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * |i - j| <= k and |nums[i] - nums[j]| <= t
 */
public class ContainsDuplicateIII {
	/* Time limit exceeded
	 * Time Complexity: O(n min(n,k)), Space: O(1) 
	 * Wrong answer for [-1,2147483647], k = 1, t = 2147483647. Output: true, Expected : false
	 */
	public boolean containsNearbyAlmostDuplicateBruteForce(int[] nums, int k, int t) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = Math.max(i - k, 0); j < i; j++) {
	            if (Math.abs(nums[i] - nums[j]) <= t) return true;
	        }
	    }
	    return false;
	}
	
	/* Second Solution - Using Balanaced BST */
	
	/* Time complexity : O(n). For each of the n elements, we do at most three searches, one insert, and one delete on the HashMap,
	 *  which costs constant time on average. Thus, the entire algorithm costs O(n) time.
	 *  Space complexity : O(min(n,k)). Space is dominated by the HashMap, which is linear to the size of its elements. 
	 *  The size of the HashMap is upper bounded by both n and k. Thus the space complexity is O(min(n,k)).
	 */
	public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
	public static void main(String[] args){
		ContainsDuplicateIII caller = new ContainsDuplicateIII();
		int[] nums = new int[] {-3,1};
		int k = 2, t = 4;
		System.out.println(caller.containsNearbyAlmostDuplicateBucket(nums, k, t));
	}
}
