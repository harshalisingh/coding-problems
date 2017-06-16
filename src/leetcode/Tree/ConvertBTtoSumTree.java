package leetcode.Tree;

/** Convert a given tree to its Sum Tree
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. 
 * The values of leaf nodes are changed to 0.
 */
public class ConvertBTtoSumTree {
	// Convert a given tree to a tree where every node contains sum of
    // values of nodes in left and right subtrees in the original tree
    int toSumTree(TreeNode root) 
    {
        // Base case
        if (root == null)
            return 0;
  
        // Store the old value
        int old_val = root.val;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        root.val = toSumTree(root.left) + toSumTree(root.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return root.val + old_val;
    }
}
