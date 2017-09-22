package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Harshali
 * https://leetcode.com/problems/invert-binary-tree/
 */

/*
 * https://leetcode.com/problems/invert-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MirrorBinaryTree {

	public TreeNode invertTree(TreeNode root) {

		if(root==null || (root.left == null && root.right == null)) return root;

		TreeNode left = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(left);
		return root;
	}

	public TreeNode invertTreeItr(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}

}
