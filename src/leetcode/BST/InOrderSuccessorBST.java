package leetcode.BST;

import leetcode.Tree.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 */
public class InOrderSuccessorBST {
	
	/*
	 * Let's take the successor for example, basically we always want to find p's closest node (in inorder traversal) 
	 * and the node's value is larger than p's value, right? That node can either be p's parent or the smallest node in p' right branch.
	 * When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.
	 * If it's p's parent node, there are two scenarios: 
	 * 		1. p doesn't have right child, in this case, the recursion will eventually return null, so p's parent is the successor; 
	 * 		2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.
	 * 
	 * If it's p's right child, there are two scenarios: 
	 * 		1. the right child has left sub tree, eventually the smallest node from the left sub tree will be the answer; 
	 * 		2. the right child has no left sub tree, the recursion will return null, then the right child (root) is our answer.
	 */
	public TreeNode successor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val <= p.val) {
			return successor(root.right, p);
		} else {
			TreeNode left = successor(root.left, p);
			return (left != null) ? left : root;
		}
	}

	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val >= p.val) {
			return predecessor(root.left, p);
		} else {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}

	//less confusing
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			if (p.val < root.val) {
				succ = root;
				root = root.left;
			}
			else
				root = root.right;
		}
		return succ;
	}
}
