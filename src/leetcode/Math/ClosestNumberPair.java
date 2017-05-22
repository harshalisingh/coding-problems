package leetcode.Math;

import java.util.Arrays;

/**
 * Find the pair with minimum difference
 * Time Complexity: O (nlogn)
 * Space Complexity: O(n)
 */
public class ClosestNumberPair {
	public static void closestNumber(int[] nums){
		Arrays.sort(nums);
		int n = nums.length;
        int[] diff = new int[n-1];
        for(int i=0; i < n-1;i++){
            diff[i] = nums[i+1] - nums[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i < n-1;i++){
            if(diff[i] < min)
                min = diff[i];
        }
        for(int i=0; i < n-1;i++){
            if(diff[i] == min)
                System.out.print(nums[i]+" "+ nums[i+1]+" ");
        }
	}
}
