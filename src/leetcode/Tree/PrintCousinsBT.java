package leetcode.Tree;

public class PrintCousinsBT {

	// This function prints cousins of a given node
	static void printCousins(TreeNode root, TreeNode node)
	{
		// Get level of given node
		int level = getLevel(root, node, 1);

		// Print nodes of given level.
		printGivenLevel(root, node, level);
	}
	
	/* It returns level of the node if it is present
	   in tree, otherwise returns 0.*/
	static int getLevel(TreeNode root, TreeNode node, int level)
	{
		// base cases
		if (root == null)
			return 0;
		if (root == node)
			return level;

		// If node is present in left subtree
		int downlevel = getLevel(root.left, node, level+1);
		if (downlevel != 0)
			return downlevel;

		// If node is not present in left subtree
		return getLevel(root.right, node, level+1);
	}

	/* Print nodes at a given level such that sibling of
	   node is not printed if it exists  */
	static void printGivenLevel(TreeNode root, TreeNode node, int level)
	{
		// Base cases
		if (root == null || level < 2)
			return;

		// If current node is parent of a node with
		// given level
		if (level == 2)
		{
			if (root.left == node || root.right == node)
				return;
			if (root.left != null)
				System.out.println(root.left.val);
			if (root.right != null)
				System.out.println(root.right.val);
		}

		// Recur for left and right subtrees
		else if (level > 2)
		{
			printGivenLevel(root.left, node, level-1);
			printGivenLevel(root.right, node, level-1);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(11);
	    root.right = new TreeNode(9);
	    root.left.left = new TreeNode(13);
	    root.left.right = new TreeNode(12);
	    root.right.left = new TreeNode(13);
	    root.right.right = new TreeNode(8);
	    
	    printCousins(root, root.left.left);
	}
}
