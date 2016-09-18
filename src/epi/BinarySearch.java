package epi;

/**
 * Correct and bug-free implementation of Binary Search
 * @author Harshali
 *
 */
public class BinarySearch {
	
	public static int bsearch(int t, int[] A){
		
		int low = 0, high = A.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(A[mid] < t){
				low = mid + 1;
			} else if(A[mid] == t){
				return mid;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}

}
