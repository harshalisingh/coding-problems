package leetcode.Tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/#/description
 */
public class BTSumRootToLeafPaths {
	public int sumNumbers(TreeNode root) {
		if (root == null)
            return 0;
        return sumR(root, 0);
	}

	public int sumR(TreeNode root, int x){
		if (root.right == null && root.left == null)
            return 10 * x + root.val;
        int val = 0;
        if (root.left != null)
            val += sumR(root.left, 10 * x + root.val);
        if (root.right != null)
            val += sumR(root.right, 10 * x + root.val);
        return val;
	}
}
