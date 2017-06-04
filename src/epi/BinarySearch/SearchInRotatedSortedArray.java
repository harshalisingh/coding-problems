package epi.BinarySearch;

public class SearchInRotatedSortedArray {
	public static void main(String[] args){
		int[] arr = {65, 66, 78, 1, 5, 23, 45, 56, 57};
		System.out.println(search(arr, 65));
	}
	public static int search(int[] A, int target) {
		if (A.length == 0) return -1;
		int lo = 0, hi = A.length-1;
		//
		if (target < A[lo] && target > A[hi]) return -1;

		while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {  //Left is normally ordered
	            if (target >= A[lo] && target < A[mid]) {  //target is in left half
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else { //Right is normally ordered
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
		return A[lo] == target ? lo : -1;
	}
}
