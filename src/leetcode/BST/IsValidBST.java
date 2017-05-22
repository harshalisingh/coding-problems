package leetcode.BST;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import leetcode.Tree.TreeNode;

/**
 * Given a binary tree, return true if it is binary search tree else return false.
 * 
 * Solution
 * Keep min, max for every recursion. Initial min and max is very small and very larger
 * number. Check if root.data is in this range. When you go left pass min and root.data and 
 * for right pass root.data and max.
 * 
 * Time complexity is O(n) since we are looking at all nodes.
 * Due to the use of recursion, space complexity is O(log N) on a balanced tree.
 * 
 * Test cases:
 * Null tree
 * 1 or 2 nodes tree
 * Binary tree which is actually BST
 * Binary tree which is not a BST
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/#/solutions
 */
public class IsValidBST {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) return true;
		
		if (root.val <= min || root.val > max) return false;
		
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}


	public boolean isValidBSTIterative(TreeNode root) {
		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(pre != null && root.val <= pre.val) return false;
			pre = root;
			root = root.right;
		}
		return true;
	}
}
