package epi;

/**
 * Exercise 6.2
 * @author Harshali
 *
 */
public class IncrementInteger {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] A = new int[] {9, 9, 9};
		
		int[] result = plusOne(A);
		
		for(int i = 0; i < result.length; ++i){
		    System.out.print(result[i]+ "");
		}
	}
	
	public static int[] plusOne(int[] A){
	    
	    int n = A.length - 1;
	    A[n] = A[n] + 1;
	    
	    for(int i = n; i > 0 && A[i] == 10; --i){
	        
	        A[i] = 0;
	        A[i-1] = A[i-1] + 1;
	    }
	    
	    if(A[0] == 10){
	        
	    	A[0] = 0;
	        int[] B = new int[A.length + 1];
	        System.arraycopy(A, 0, B, 0, A.length);
	        B[0] = 1;
	        
	        return B;
	    } else {
		    return A;	    	
	    }
	    
	}

}
