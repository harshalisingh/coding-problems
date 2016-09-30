package epi.BinarySearch;

import java.util.List;

public class SearchCyclicallySortedArray {
	
	public static int searchSmallest(List<Integer> A){
		
		int low = 0, high = A.size() - 1;
		
		while(low < high){
			int mid = low + (high - low)/2;
			
			if(A.get(mid) < A.get(high)){
				
				//minimum must be in (low, mid + 1)
				high = mid;
				
			} else {
				//A.get(mid) > A.get(right)
				//minimum must be in (m+1, high+1)
				low = mid + 1;
			}
		}
		
		return low;
	}

}
