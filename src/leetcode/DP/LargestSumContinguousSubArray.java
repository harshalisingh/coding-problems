package leetcode.DP;

public class LargestSumContinguousSubArray {
	public static int maxSubArray(int[] A) {
		int maxSoFar=A[0], maxEndingHere=A[0];
		for (int i=1;i<A.length;++i){
			maxEndingHere= Math.max(maxEndingHere+A[i], A[i]);
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
		LargestSumContinguousSubArray lcs = new LargestSumContinguousSubArray();
		int[] input = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(lcs.maxSubArray(input));
	}
}
