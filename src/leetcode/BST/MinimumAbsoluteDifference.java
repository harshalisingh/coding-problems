package leetcode.BST;

import leetcode.Tree.TreeNode;
/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 */
public class MinimumAbsoluteDifference {
	private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != null){
            min = Math.min(min, root.val-pre.val);
        }
        pre = root;
        inorder(root.right);
    }
}
