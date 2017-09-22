package epi.BinarySearch;

/**
 * Correct and bug-free implementation of Binary Search
 * @author Harshali
 *
 */
public class BinarySearch {

	public static int bsearch(int[] A, int t){

		int low = 0, high = A.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(A[mid] == t){
				return mid;
			} else if(A[mid] < t){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;  //or return low, if want to return insert position
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(bsearch(arr, 8));
	}

}
