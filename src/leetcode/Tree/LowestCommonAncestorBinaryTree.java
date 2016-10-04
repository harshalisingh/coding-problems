package leetcode.Tree;

public class LowestCommonAncestorBinaryTree {
	public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
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
