package leetcode.Tree;

//http://www.geeksforgeeks.org/flip-binary-tree/
//Binary Tree Upside Down - LeetCode
public class FlipBT {
	// method to flip the binary tree
	TreeNode flipBinaryTree(TreeNode root)
	{
	    // Base cases
	    if (root == null || root.left == null && root.right == null)
	        return root;

	    //  recursively call the same method
	    TreeNode flippedRoot = flipBinaryTree(root.left);
	 
	    //  rearranging main root Node after returning
	    // from recursive call
	    root.left.left = root.right;
	    root.left.right = root;
	    root.left = null;
	    root.right = null;
	    
	    return flippedRoot;
	}
}
