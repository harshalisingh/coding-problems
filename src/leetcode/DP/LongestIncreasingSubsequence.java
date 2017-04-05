package leetcode.DP;

/*
 * Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing subsequence is [2, 3, 7, 101], 
 * therefore the length is 4.
 * https://leetcode.com/problems/longest-increasing-subsequence/#/description
 * 
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) 
	{
		// Base case
		if(nums.length <= 1) 
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
			T[i] = 1;

		// Mark one pointer at i. For each i, start from j=0.
		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				// It means next number contributes to increasing sequence.
				if(nums[j] < nums[i])
				{
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					T[i] = Math.max(T[i], T[j] + 1);
				}
			}
		}

		// Find the maximum length from the array that we just generated 
		int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
	}
	
	/*
	 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	 * running time complexity is O(n).
	 */
	public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}
