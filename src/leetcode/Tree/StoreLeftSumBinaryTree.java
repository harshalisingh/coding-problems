package leetcode.Tree;

/**
 * Given a Binary Tree, change the value in each node to sum of all the values in the nodes in the left subtree including its own.
 * http://www.geeksforgeeks.org/change-a-binary-tree-so-that-every-node-stores-sum-of-all-nodes-in-left-subtree/
 */
public class StoreLeftSumBinaryTree {
	/*Function to modify a Binary Tree so that every node
	* stores sum of values in its left child including its
	* own value.
	* Time Complexity: O(n)
	*/
	public int updatetree(TreeNode root)
	{
	    // Base cases
	    if (root == null)
	        return 0;
	    
	    if (root.left == null && root.right == null)
	        return root.val;
	 
	    // Update left and right subtrees
	    int leftsum  = updatetree(root.left);
	    int rightsum = updatetree(root.right);
	 
	    //Add leftsum to current node
	    root.val += leftsum;
	 
	    // Return sum of values under root
	    return root.val + rightsum;
	}
}
