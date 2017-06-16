package leetcode.Tree;


/*
 * Given a binary tree, find the diameter of it.
 * Diameter of tree is defined as A longest path or route between any two nodes in a tree. 
 * The path may or may not for through the root.
 * Maximum(Diameter of left subtree, Diameter of right subtree, 
 * Longest path between two nodes which passes through the root.)
 */
public class DiameterBinaryTree {
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		else{
			return  (1+ Math.max(getHeight(root.left), getHeight(root.right)));
		}
	}

	public int diameter(TreeNode root) {
		if(root == null)
			return 0;
		// get the left and right subtree height
		int leftH = getHeight(root.left);
		int rightH = getHeight(root.right);

		// get the left diameter and right diameter recursively.
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);

		// get the max leftsubtree, rightsubtree, longest path goes through
		// root.
		return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
	}
	public int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
}
