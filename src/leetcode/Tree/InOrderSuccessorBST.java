package leetcode.Tree;

public class InOrderSuccessorBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    TreeNode succ = null;
	    while (root != null) {
	        if (p.data < root.data) {
	            succ = root;
	            root = root.left;
	        }
	        else
	            root = root.right;
	    }
	    return succ;
	}
}
