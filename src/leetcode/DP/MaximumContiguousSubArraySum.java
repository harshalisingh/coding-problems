package leetcode.DP;

public class MaximumContiguousSubArraySum {

	public int kandane(int[] arrA) {
		int max_end_here = 0;
		int max_so_far = 0;
		for (int i = 0; i < arrA.length; i++) {
			max_end_here += arrA[i];
			if (max_end_here < 0) {
				max_end_here = 0;
			}
			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
			}
		}
		return max_so_far;
	}

	public static int maxSubArray(int[] A) {
		int maxEndingHere=A[0], maxSoFar=A[0];
		for (int i = 1;i < A.length; ++i){
			maxEndingHere= Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar=Math.max(maxSoFar, maxEndingHere);	
		}
		return maxSoFar;
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
	
	public static void main(String[] args){
		MaximumContiguousSubArraySum lcs = new MaximumContiguousSubArraySum();
		int[] input = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(lcs.maxSubArray(input));
	}
}
