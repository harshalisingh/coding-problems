package leetcode;

import leetcode.common.TreeNode;

/**
 * 
 * @author Harshali
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 */

public class MaxDepthBinaryTree {

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		else{
			return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
		}
	}

}
