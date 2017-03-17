package leetcode.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
	
	//Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort
	public boolean containsDuplicateUsingSort(int[] nums) {

        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
	
	//Time complexity: O(N), memory: O(N)
	public boolean containsDuplicate(int[] nums) {

	    final Set<Integer> distinct = new HashSet<Integer>();
	    for(int num : nums) {
	        if(distinct.contains(num)) {
	            return true;
	        }
	        distinct.add(num);
	    }
	    return false;
	}
}
