package leetcode.ArraySpecial;

/*
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * Time Complexity: O(n)
 */
public class MinimumSizeSubArraySum {
	
	//Time Complexity: O(n^2), Space: O(n)
	public int minSubArrayLenBruteForce(int s, int[] a) {
		if (a == null || a.length == 0) return 0;
		int n = a.length, ans = Integer.MAX_VALUE;
		int[] sums = new int[n];
	    sums[0] = a[0];
	    for (int i = 1; i < n; i++)
	        sums[i] = sums[i - 1] + a[i];
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int sum = sums[j] - sums[i] + a[i];
	            if (sum >= s) {
	                ans = Math.min(ans, (j - i + 1));
	                break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
	            }
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	//Time complexity: O(n), Space: O(1)
	public int minSubArrayLen(int s, int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int left = 0, sum = 0, ans = Integer.MAX_VALUE, n = a.length;
		for (int i = 0; i < n; i++) {
	        sum += a[i];
	        while (sum >= s) {
	            ans = Math.min(ans, i + 1 - left);
	            sum -= a[left++];
	        }
	    }
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}
