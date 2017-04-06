package leetcode.BST;

import java.util.Stack;

import leetcode.Tree.TreeNode;

public class KthSmallestBST {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);    
				root = root.left;   
			} 
			root = stack.pop();
			if(--k == 0) break;
			root = root.right;
		}
		return root.val;
	}
}
