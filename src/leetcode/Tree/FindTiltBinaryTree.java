package leetcode.Tree;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference 
 * between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class FindTiltBinaryTree {
	int tilt = 0;

	public int findTilt(TreeNode root) {
		postorder(root);
		return tilt;
	}

	public int postorder(TreeNode root) {
		if (root == null) return 0;
		int leftSum = postorder(root.left);
		int rightSum = postorder(root.right);
		tilt += Math.abs(leftSum - rightSum);
		return leftSum + rightSum + root.val;
	}

}
