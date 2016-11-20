package leetcode.BST;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBST {
	public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root.val > Math.max(n1.val, n2.val)) {
            return lca(root.left, n1, n2);
        } else if (root.val < Math.min(n1.val, n2.val)) {
            return lca(root.right, n1, n2);
        } else {
            return root;
        }
    }
}
