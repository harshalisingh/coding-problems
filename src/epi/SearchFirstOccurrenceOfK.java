package epi;

import java.util.Arrays;
import java.util.List;

public class SearchFirstOccurrenceOfK {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Integer> A = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
		System.out.print(searchFirstOfK(A, 285));
	}
	
	public static int searchFirstOfK(List<Integer> A, int k){
	    int low = 0, high = A.size() - 1, result = -1;
	    
	    while(low <= high){
	        int mid = low + (high - low)/2;
	        if(A.get(mid) < k){
	            low = mid + 1;
	        } else if(A.get(mid) == k){
	            
	        	result = mid;
	            
	            //Nothing to the right of mid can be the first occurrence of k
	            high = mid - 1;
	            
	        } else {
	            high = mid - 1;
	        }
	    }
	    
	    return result;
	}

}
