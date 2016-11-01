package leetcode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

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
		traverseLeft(root);
	}

	/** return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		traverseLeft(node.right);
		return node.data;
	}

	private void traverseLeft(TreeNode node){
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}

