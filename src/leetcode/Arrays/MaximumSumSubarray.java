package leetcode.Arrays;

public class MaximumSumSubarray {
	public int maxSubArray(int[] A) {
		int res = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = Math.max(sum, 0) + A[i];
			res = Math.max(res, sum);
		}
		return res;
	}  
}
