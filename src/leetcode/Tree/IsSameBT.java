package leetcode.Tree;

/*
 * https://leetcode.com/problems/same-tree/#/description
 * Given two binary trees, write a function to check if they are equal or not.
 */
public class IsSameBT {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
