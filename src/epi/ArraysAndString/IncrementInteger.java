package epi.ArraysAndString;

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
	
	public static int[] plusOne(int[] digits){
	    
		int n = digits.length - 1;
        digits[n] = digits[n] + 1;
        for(int i = n; i > 0 && digits[i] == 10; --i){
            digits[i] = 0;
            digits[i-1] = digits[i-1] + 1;
        }
        
        if(digits[0] == 10){
            digits[0] = 0;
            int[] B = new int[digits.length + 1];
	        B[0] = 1;
	        return B;
	        } else {
	        	return digits;
            }     
        }
	}

