package leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * Time Complexity: O (n^2)
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new ArrayList<>();
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || num[i] != num[i-1]) { // skip duplicates
	        	
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;  // skip duplicates
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;  // skip duplicates
	                    lo++; hi--;
	                    
	                } else if (num[lo] + num[hi] < sum){
	                	lo++;
	                }
	                else{
	                	hi--;
	                }
	           }
	        }
	    }
	    return res;
	}
}
