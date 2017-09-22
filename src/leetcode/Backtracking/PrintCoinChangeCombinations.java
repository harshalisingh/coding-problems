package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintCoinChangeCombinations {
	public List<List<Integer>> coinChangeSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		//Arrays.sort(nums);
		int[] counts = new int[nums.length];  
		backtrack(list, nums, counts, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, int [] nums, int[] counts, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0){
			for (int i = 0; i < nums.length; i++) {  
				System.out.print("" + counts[i] + " * " + nums[i] + " + ");  
			}   
			System.out.println();   
		}
		else{ 
			for(int i = start; i < nums.length; i++){
				counts[i]++; 
				backtrack(list, nums, counts, remain - nums[i], i); // not i + 1 because we can reuse same elements
				counts[i]--; 
			}
		}
	}

	public static void main(String[] args){
		PrintCoinChangeCombinations obj = new PrintCoinChangeCombinations();
		int[] nums = new int[] {25, 10, 5, 1};
		int amount = 25;
		obj.coinChangeSum(nums, amount);
	}
}
