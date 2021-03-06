package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * https://leetcode.com/problems/combination-sum/
 * 
 * Same as Print all coin combinations that sum to a denomination
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		//Arrays.sort(nums);     sorting is not necessary
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else{ 
			for(int i = start; i < nums.length; i++){
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		CombinationSum cs = new CombinationSum();
		int[] nums = new int[] {2, 1, 3};
		int target = 4;
		List<List<Integer>> list = cs.combinationSum(nums, target);
		for(List<Integer> comb : list){
			System.out.println(comb.toString());
		}
	}

}
