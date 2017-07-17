package leetcode.Arrays.MissingOrDuplicate;

import java.util.Arrays;

/** Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example, Given nums = [0, 1, 3] return 2.
 * https://leetcode.com/problems/missing-number/#/description
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int sum = 0;
		for(int num: nums)
			sum += num;

		return (nums.length * (nums.length + 1) )/ 2 - sum;
	}


	public int missingNumberBinarySearch(int[] nums) { //binary search
		Arrays.sort(nums);
		int left = 0, right = nums.length, mid= (left + right)/2;
		while(left<right){
			mid = (left + right)/2;
			if(nums[mid]>mid) right = mid;
			else left = mid+1;
		}
		return left;
	}

	/* XOR operation. We know a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
	 * Apply XOR operation to both the index and value of the array. 
	 * In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), 
	 * so in a missing array, what left finally is the missing number.
	 * 
	 */
	public int missingNumberXOR(int[] nums) { //xor
		int res = nums.length;
		for(int i=0; i < nums.length; i++){
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}
