package leetcode;

import leetcode.common.TreeNode;

/**
 * 
 * @author Harshali
 * https://leetcode.com/problems/invert-binary-tree/
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {

        if(root==null || (root.left == null && root.right == null)) return root;
        
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;

    }

}
