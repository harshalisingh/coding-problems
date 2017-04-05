package leetcode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
 * (assume that the array is non-empty and the majority element always exist in the array.)
 * https://leetcode.com/problems/majority-element/#/description
 */
public class MajorityElement {
	// Sorting
	public int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}

	// Hashtable 
	public int majorityElement2(int[] nums) {
	    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
	    int ret=0;
	    for (int num: nums) {
	        if (!myMap.containsKey(num))
	            myMap.put(num, 1);
	        else
	            myMap.put(num, myMap.get(num)+1);
	        if (myMap.get(num)>nums.length/2) {
	            ret = num;
	            break;
	        }
	    }
	    return ret;
	}
	
	// Moore voting algorithm
	public int majorityElement3(int[] nums) {
	    int count=0, ret = 0;
	    for (int num: nums) {
	        if (count==0)
	            ret = num;
	        if (num!=ret)
	            count--;
	        else
	            count++;
	    }
	    return ret;
	}

	//Bit Manipulation
	public int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (nums[i] >> j) & 1;
            }
        }
        int majority = 0;
        for (int j = 0; j < 32; j++) {
            bit[j] = bit[j] > (nums.length / 2)? 1 : 0;
            majority += bit[j] << j;
        }
        return majority;
    }
}
