package leetcode.Tree;

import java.util.HashMap;

/*
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class BTPathSumIII {
    int count = 0;
    
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);          //Default sum = 0 has one count
        helper(root, 0, sum, preSum);
        return count;
    }

    public void helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }
        
        sum += root.data;

        if (preSum.containsKey(sum - target)) {      //See if there is a subarray sum equals to target
            count += preSum.get(sum - target);
        }
        
        if (!preSum.containsKey(sum)) {
            preSum.put(sum, 1);
        } else {
            preSum.put(sum, preSum.get(sum)+1);
        }
        
      //Extend to left and right child
        helper(root.left, sum, target, preSum);
        helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);     //Remove the current node so it wont affect other path
    }
}
