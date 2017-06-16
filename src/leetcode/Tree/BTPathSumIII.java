package leetcode.Tree;

import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * https://leetcode.com/problems/path-sum-iii/#/description
 */
public class BTPathSumIII {
	/* Typical recursive DFS.
	 * Space: O(n) due to recursion.
	 * Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
	 */
	public int pathSumDFS(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int pathSumFrom(TreeNode node, int sum) {
		if (node == null) return 0;
		return (node.val == sum ? 1 : 0) 
				+ pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
	}

	/*
	 *  It use a hash map to store all the prefix sum and each time check if the any subarray sum to the target
	 */
	public int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0,1);          //Default sum = 0 has one count
		return helper(root, 0, sum, preSum);
	}

	public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		if (root == null) {
			return 0;
		}
		currSum += root.val;
		int res = preSum.getOrDefault(currSum - target, 0);       //See if there is a subarray sum equals to target
		preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

		//Extend to left and right child
		res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
		preSum.put(currSum, preSum.get(currSum) - 1);      //Remove the current node so it wont affect other path
		return res;
	}
}
