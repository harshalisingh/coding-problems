package leetcode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { data = x; }
}

public class BSTIterator1 {

	private Deque<TreeNode> stack;

	public BSTIterator1(TreeNode root) {
		stack = new ArrayDeque<TreeNode>();
		traverse(root);
	}

	/** return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		traverse(node.right);
		return node.data;
	}

	private void traverse(TreeNode node){
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}

