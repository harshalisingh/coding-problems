package leetcode.BST;

import leetcode.Tree.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Just walk down from the whole tree's root as long as both p and q are in the same subtree 
 * (meaning their values are both smaller or both larger than root's).
 */
public class LowestCommonAncestorBST {
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val)) {
            return lca(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lca(root.right, p, q);
        } else {
            return root;
        }
    }
}
