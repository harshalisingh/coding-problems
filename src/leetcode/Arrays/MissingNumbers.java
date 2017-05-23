package leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Time: O(n)
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 */
public class MissingNumbers {
	//we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. 
	//In this way all the numbers that we have seen, those indices will be marked as negative. 
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
