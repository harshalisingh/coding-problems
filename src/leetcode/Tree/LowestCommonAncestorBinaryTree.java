package leetcode.Tree;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
 */
public class LowestCommonAncestorBinaryTree {
	public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null || root == n1 || root == n2){
            return root;
        }
        
        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
