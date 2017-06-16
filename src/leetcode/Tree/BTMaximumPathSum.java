package leetcode.Tree;

/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree 
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
public class BTMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathDown(root);
	    return max;
	}

	/* A recursive method maxPathDown(TreeNode node) 
	 * (1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
	 * (2) returns the maximum sum of the path that can be extended to input node's parent.
	 */
	public int maxPathDown(TreeNode root) {
	    if(root == null)
	        return Integer.MIN_VALUE;
	    int left = Math.max(0, maxPathDown(root.left));
	    int right = Math.max(0, maxPathDown(root.right));
	    max = Math.max(max, root.val + left + right);
	    return root.val + Math.max(left, right);
	}

}
