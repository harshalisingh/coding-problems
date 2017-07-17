package leetcode.ArraySpecial;

import java.util.HashMap;
import java.util.Map;

/** Continuous Subarray Sum
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, 
 * that is, sums up to n*k where n is also an integer.
 */
public class ContinuousSubarraySumK {
	
	/* The main idea is that (x + n*k) mod k = x ,which x can be 0,1,...,k-1.
	 * For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0]. 
	 * We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k.
	 * [0], 0 -> false;
	 * [5, 2, 4], 5 -> false;
	 * [0, 0], 100 -> true;
	 * [1,5], -6 -> true;
	 */
	public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0,  -1);
    int runningRemainder = 0;
    for (int i=0;i<nums.length;i++) {
        runningRemainder += nums[i];
        if (k != 0) {
        	runningRemainder %= k; 
        }
        Integer prev = map.get(runningRemainder);
        if (prev != null) {
            if (i - prev > 1) return true;
        }
        else map.put(runningRemainder, i);
    }
    return false;
}
}
