package leetcode.Tree;

import java.util.Stack;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * 
 * Preorder traversing implies that PRE[0] is the root node.
 * Then we can find this PRE[0] in IN, say it's IN[5].
 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
 * Recursively doing this on subarrays, we can build a tree out of it :)
 */
public class ConstructPreOrderInOrderBT {
	public TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder) {
	    return helperPreorderInorder(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helperPreorderInorder(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	            break;
	        }
	    }
	    int leftTreeLen = inIndex - inStart;
	    root.left = helperPreorderInorder(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helperPreorderInorder(preStart + leftTreeLen + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
}
