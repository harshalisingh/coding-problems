package leetcode.ArraySpecial;

public class IncreasingTripletSubsequence {
	/*
	 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	 * running time complexity is O(n).
	 */
	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
		for(int num : nums){
			if(num <= min) min = num;
			else if(num < secondMin) secondMin = num;
			else if(num > secondMin) return true;
		}
		return false;
	}
}
