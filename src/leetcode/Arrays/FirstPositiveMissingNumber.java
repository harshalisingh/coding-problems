package leetcode.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * https://leetcode.com/problems/first-missing-positive/#/description
 */
public class FirstPositiveMissingNumber {
	
	//Time: O(n), Space: O(1)
	public static int firstMissingPositiveNumber(int[] A){
		
		//Record which values are present by writing A[i] to index A[i] - 1
		//if A[i] is between 1 and A.length, inclusive. We save the value at index A[i] - 1
		//by swapping it with the entry at i. If A[i] is negative or greater than n, we just advance i.
		int i = 0;
		while(i < A.length){
			if(A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]){
				swap(A, i, A[i] - 1);
			} else {
				++i;
			}
		}
		
		for(i = 0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		
		//Second pass through A to search for the first index i such that A[i] != i + 1,
		//indicating that i + 1 is absent. If all numbers between 1 and A.length are present, the
		//smallest missing positive number is A.length + 1.
		for(i = 0; i < A.length; i++){
			if(A[i] != i + 1){
				return i + 1;
			}
		}
		
		return A.length + 1;
	}
	
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
	}
	
	//Basically for each number (if between 1 and A.length), put it in it's corresponding index.
	public static void main(String[] args){
		int[] nums = {6, 0, 4, 3, -1, -2, 5};
		System.out.println(firstMissingPositiveNumber(nums));
	}
}
