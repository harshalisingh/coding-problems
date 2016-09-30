package leetcode.Arrays;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
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
