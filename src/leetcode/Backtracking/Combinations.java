package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/** Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * https://leetcode.com/problems/combinations/#/description
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public void combine(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
		if(tempList.size() == k) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		} else {
			for(int i=start; i<=n; i++) {
				tempList.add(i);
				combine(result, tempList, i+1, n, k); //i+1 because we can't reuse the same element in single combination
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Combinations obj = new Combinations();
    	
    	for(List<Integer> list : obj.combine(5, 2)){
    		System.out.println(list.toString());
    	}
    }
}
