package leetcode.ArraySpecial;

/** 
 * Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubArray {

	public int maxProductSubArray(int[] A) {
		int min;
		int res = A[0], max = min = A[0]; // max, min means max and min product among the subarrays whose last element is A[i].
		for (int i = 1; i < A.length; i++) {
			if (A[i] > 0) {
				max = Math.max(max * A[i], A[i]);
				min = Math.min(min * A[i], A[i]);
			}
			else {
				int lastMax = max;
				max = Math.max(min * A[i], A[i]);
				min = Math.min(lastMax * A[i], A[i]);
			}
			res = Math.max(res, max);
		}
		return res;
	}
	
	public static void main(String[] args){
		MaximumProductSubArray mps = new MaximumProductSubArray();
		int[] input = {2, 3, -2, 4};
		System.out.println(mps.maxProductSubArray(input));
	}
}
