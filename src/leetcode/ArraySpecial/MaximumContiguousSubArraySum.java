package leetcode.ArraySpecial;

public class MaximumContiguousSubArraySum {
	//Kadane's Algorithm
	public int maxSubArraySum(int[] A) {
		int maxSumEndingHere=A[0], maxSumSoFar=A[0];
		for (int i = 1;i < A.length; ++i){
			maxSumEndingHere= Math.max(maxSumEndingHere + A[i], A[i]);
			maxSumSoFar=Math.max(maxSumSoFar, maxSumEndingHere);	
		}
		return maxSumSoFar;
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
		System.out.println(lcs.maxSubArraySum(input));
	}
}
