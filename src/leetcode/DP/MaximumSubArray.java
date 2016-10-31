package leetcode.DP;

public class MaximumSubArray {
	public int maxSumSubArray(int[] A) {
		int res = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = Math.max(sum, 0) + A[i];
			res = Math.max(res, sum);
		}
		return res;
	}

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
}
