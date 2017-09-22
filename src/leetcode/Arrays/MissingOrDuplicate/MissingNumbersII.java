package leetcode.Arrays.MissingOrDuplicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Time: O(n)
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 */
public class MissingNumbersII {

	public List<Integer> findDisappearedNumbers(int[] A) {
		int i = 0;
		while(i < A.length){
			if(A[i] != A[A[i] - 1]){
				swap(A, i, A[i] - 1);
			} else {
				++i;
			}
		}

		//Second pass through A to search for the first index i such that A[i] != i + 1,
		//indicating that i + 1 is absent. If all numbers between 1 and A.length are present, the
		//smallest missing positive number is A.length + 1.
		List<Integer> result = new ArrayList<>();
		for(i = 0; i < A.length; i++){
			if(A[i] != i + 1){
				result.add(i+1);
			}
		}	
		return result;
	}
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	//we iterate through the input array and mark elements as negative using nums[nums[i]-1] = -nums[nums[i]-1]. 
	//In this way all the numbers that we have seen, those indices will be marked as negative. 
	public List<Integer> findDisappearedNumbersNegation(int[] A) {
		List<Integer> ret = new ArrayList<Integer>();

		for(int i = 0; i < A.length; i++) {
			int val = Math.abs(A[i]) - 1;
			if(A[val] > 0) {
				A[val] = -A[val];
			}
		}

		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0) {
				ret.add(i+1);
			}
		}
		return ret;
	}
}
