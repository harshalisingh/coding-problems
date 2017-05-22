package epi.BinarySearch;

public class FindMinInRotatedSortedArray {
	
	public static int searchSmallest(int[] A){
		
		int low = 0, high = A.length - 1;
		
		while(low < high){
			int mid = low + (high - low)/2;
			
			if(A[mid] < A[high]){
				
				//minimum must be in (low, mid + 1)
				high = mid;
				
			} else {
				//A.get(mid) > A.get(right)
				//minimum must be in (m+1, high)
				low = mid + 1;
			}
		}
		
		return A[low];
	}
	
	public static void main(String[] args){
		int[] A = {6,7,1,2,3,4,5};
		System.out.println(searchSmallest(A));
	}

}
