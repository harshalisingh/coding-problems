package leetcode.DP;

/*
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 * such that the integers in the subsequence are sorted in increasing order. 
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 */
public class LargestSumIncreasingSubsequence {
	public static int largestSumIncreasingSubseq(int[] nums){
		int n = nums.length;
		if(n <= 1)
			return nums[0];

		int[] T = new int[n];

		for(int i = 0; i < n; i++){
			T[i] = nums[i];
		}

		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] > nums[j]){
					T[i] = Math.max(T[i], T[j] + nums[i]);
				}
			}
		}

		// Find the maximum length from the array that we just generated 
		int largest = 0;
		for(int i=0; i < T.length; i++)
			largest = Math.max(largest, T[i]);

		return largest;

	}
	
	/* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing "+
                           " subsequence is "+
       largestSumIncreasingSubseq(arr) );
    }
}
