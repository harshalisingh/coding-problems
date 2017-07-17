package leetcode.contest;

public class FindMedianTwoSortedArrays {
	/* The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B:
	 * if (aMid < bMid) Keep [aRight + bLeft]    
	 * else Keep [bRight + aLeft]
	 * 
	 * A median is the middle value of a dataset. We do not care about the actual value of the numbers, what we want is the middle point from the 
	 * combination of 2 arrays. In other words, we are looking for the middle index of the 2 arrays. 
	 * Based on the fact that the 2 arrays are sorted seperatedly, we could try to get the submedian of the 2 arrays in each round and compare them. 
	 * Basic idea is that the left half of the array with a smaller submedian can never contain the common median.
	 * Time: O(log(m + n))
	 */

	public double findMedianSortedArrays(int[] A, int[] B) {

		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2; //left half of the combined median (lth element)
		int r = (m + n + 2) / 2; //right half of the combined median (rth element)

		// If the A.length + B.length is odd, the 2 function will return the same number
		// Else if A.length + B.length is even, the 2 function will return the left number and right number that make up a median
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	// This function finds the Kth element in A + B
	private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {

		if (aStart > A.length - 1) return B[bStart + k - 1];   // If A is exhausted, return kth number in B	 
		if (bStart > B.length - 1) return A[aStart + k - 1];   // If B is exhausted, return kth number in A

		// If k == 1, return the first number
		// Since A and B are sorted, the smaller one among the start point of A and B is the first one
		if (k == 1) return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;

		//A, B are different size array, only if the index < array.Length, the index will be valid, 
		//otherwise, set mid to int.Max, so we will always keep the left part(low index) of array
		if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
		if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        

		// Throw away half of the array from A or B. And cut k in half
		if (aMid < bMid) 
			return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
		else 
			return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
	}
}
