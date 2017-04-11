package epi.BinarySearch;

public class SearchInRotatedSortedArray {
	public static void main(String[] args){
		int[] arr = {65, 66, 78, 1, 5, 23, 45, 56, 57};
		System.out.println(search(arr, 65));
	}
	public static int search(int[] A, int target) {
		if (A.length == 0) return -1;
		int L = 0, R = A.length-1;
		//
		if (target < A[L] && target > A[R]) return -1;

		while (L < R) {
			int M = L + ((R - L)/2);
			if (A[M] <= A[R]) {
				if (target > A[M] && target <= A[R]) {
					L = M+1;
				} else {
					R = M;
				}

			} else {  //A[M] > A[R]
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
