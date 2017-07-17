package leetcode.Arrays;

import java.util.Arrays;

/** 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
	    Arrays.sort(nums);
	    int sum = nums[0] + nums[1] + nums[nums.length - 1];
	    int closestSum = sum;
	    
	    for(int i = 0; i < nums.length - 2; i++){
	        if(i==0 || nums[i]!=nums[i-1]){
	        	
	            int lo = i + 1, hi = nums.length - 1;
	            while(lo < hi){
	                sum = nums[lo] + nums[hi] + nums[i];
	                if(sum < target){
	                    //move closer to target sum.
	                    while(lo < hi && nums[lo] == nums[lo+1]){
	                    	lo++;
	                    }
	                    lo++;
	                }else if(sum > target){
	                    //move closer to target sum.
	                    while(lo < hi && nums[hi] == nums[hi-1]){
	                    	hi--;
	                    }
	                    hi--;
	                }else{
	                    return sum;
	                }
	                //update the closest sum if needed.
	                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
	                    closestSum = sum;
	                }
	            }
	        }

	    }
	    return closestSum;
	}
}
