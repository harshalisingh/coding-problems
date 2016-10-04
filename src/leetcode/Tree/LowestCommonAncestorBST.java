package leetcode.Tree;

public class LowestCommonAncestorBST {
	public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root.data > Math.max(n1.data, n2.data)) {
            return lca(root.left, n1, n2);
        } else if (root.data < Math.min(n1.data, n2.data)) {
            return lca(root.right, n1, n2);
        } else {
            return root;
        }
    }
}
