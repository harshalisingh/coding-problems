package leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

//Time Complexity : O(n)

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	//Input is sorted
	public static int[] twoSumSorted(int[] numbers, int target){
		if(numbers == null || numbers.length == 0){
			return null;
		}		
		int i = 0; int j = numbers.length - 1;
		while(i < j){
			int x = numbers[i] + numbers[j];
			if(x < target){
				++i;
			} else if(x > target){
				j--;
			} else {
				return new int[] {i, j};
			}
		}
		return null;
	}

	public static void main(String[] args){
		int[] numbers = new int[]{2, 5, 7, 8, 9};
		int target = 9;

		int[] result = twoSumSorted(numbers, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
