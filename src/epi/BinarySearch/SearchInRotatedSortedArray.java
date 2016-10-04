package epi.BinarySearch;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A.length == 0) return -1;
		int L = 0, R = A.length-1;
		//
		if (target < A[L] && target > A[R]) return -1;

		while (L < R) {
			int M = (L + R)/2;
			if (A[M] <= A[R]) {
				if (target > A[M] && target <= A[R]) {
					L = M+1;
				} else {
					R = M;
				}

			} else {
				if (target <= A[M] && target >= A[L]) {
					R = M;
				} else {
					L = M+1;
				}
			}
		}
		if (A[L] == target) return L;
		else return -1;
	}
}
