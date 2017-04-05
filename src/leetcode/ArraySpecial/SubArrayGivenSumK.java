package leetcode.ArraySpecial;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an unsorted array of integers, find a contiguous subarray which adds to a given sum. 
 * If there are more than one subarrays with sum as the given number, print any of them.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SubArrayGivenSumK {
	public void subArraySum(int arr[], int n, int sum){
		Map<Integer, Integer> map = new HashMap<>();
		int curr_sum = 0;
		for (int i = 0; i < n; i++)
	    {
	        // add current element to curr_sum
	        curr_sum = curr_sum + arr[i];
	 
	        // if curr_sum is equal to target sum
	        // we found a subarray starting from index 0
	        // and ending at index i
	        if (curr_sum == sum)
	        {
	        	System.out.println("Sum found between indexes " + 0 + " : " + i);
	            //return;
	        }
	 
	        // If curr_sum - sum already exists in map
	        // we have found a subarray with target sum
	        if (map.containsKey(curr_sum - sum))
	        {
	        	System.out.println("Sum found between indexes " + (map.get(curr_sum - sum) + 1) + " : " + i);
	            //return;
	        }
	 
	        map.put(curr_sum, i);
	    }
	 
	    // If we reach here, then no subarray exists
		System.out.println("No subarray with given sum exists");
	}
	public static void main(String[] args) 
	{
		SubArrayGivenSumK arraysum = new SubArrayGivenSumK();
		int arr[] = {1, 5, 7, 10, 9, 23};
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySum(arr, n, sum);
	}
}
