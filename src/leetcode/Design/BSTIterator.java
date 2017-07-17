package leetcode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Tree.TreeNode;

/** Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *      6
 *     /
 *    3
 *     \
 *       5
 *      /
 *     4
 */

public class BSTIterator {
	private Deque<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new ArrayDeque<>();
		addleftNodes(root);
	}

	private void addleftNodes(TreeNode cur){
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		// traversal right branch
		if(cur.right != null){
			cur = cur.right;
			addleftNodes(cur);
		}
		return node.val;
	}
}
