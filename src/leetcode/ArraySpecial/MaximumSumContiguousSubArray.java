package leetcode.ArraySpecial;

/*
 * Largest sum contiguous subarray (Kadane's algorithm)
 * DP: O(N) Time, O(1) Space
 */
public class MaximumSumContiguousSubArray {
	public static void maxSubArray(int[] nums) {
		int startIndex = 0, endIndex = 0;
	    int currStartIndex = 0;
	 
	    int maxSum = 0;
	    int currentSum = 0;
	 
	    for(int i = 0 ; i < nums.length; i++){
	        currentSum  = currentSum + nums[i];
	        
	        // case 1 : When ith element can be included
	        // Change the end index and also update the start index.
	        if(currentSum > maxSum){
	            maxSum = currentSum;
	            endIndex = i;
	            startIndex = currStartIndex;
	        }
	        /*case 2 : When ith index cannot be included and 
	        we need to start with i+1 index. till now our max sum
	        and start and end index of that sum remain same */
	        if(currentSum < 0){
	            currStartIndex = i + 1;
	            currentSum = 0;
	        }
	    }
	    System.out.println("\nMaximum Sum : " + maxSum);
	    System.out.println("\nBetween :" + startIndex + ", " + endIndex);
    }
	
	public static void main(String[] args){
		int intArr[] = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		maxSubArray(intArr);
	}
}
