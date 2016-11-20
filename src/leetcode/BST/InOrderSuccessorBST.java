package leetcode.BST;
public class InOrderSuccessorBST {
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
