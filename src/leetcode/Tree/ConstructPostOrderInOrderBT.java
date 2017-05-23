package leetcode.Tree;

import java.util.Stack;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * Postorder traversing implies that POST[POST.length - 1] is the root node, i.e. last node.
 *
 */
public class ConstructPostOrderInOrderBT {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeInPost(postorder.length-1, 0, inorder.length-1, postorder, inorder);	
	}
	private TreeNode buildTreeInPost(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
		if(inStart > inEnd || postStart < 0) return null;
		
		TreeNode root = new TreeNode(postorder[postStart]);
		int inIndex = 0;
		for (int i=inStart; i<=inEnd; i++) {
			if(inorder[i] == root.val){
				inIndex = i;
				break;
			}
		}
		
		int rightTreelen = inEnd-inIndex;
		root.left = buildTreeInPost(postStart-rightTreelen-1, inStart, inIndex-1, postorder, inorder);
		root.right = buildTreeInPost(postStart-1, inIndex+1, inEnd, postorder, inorder);	
		
		return root;
	}
	
	public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
	    if (inorder.length == 0 || postorder.length == 0) return null;
	    int ip = inorder.length - 1;
	    int pp = postorder.length - 1;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null;
	    TreeNode root = new TreeNode(postorder[pp]);
	    stack.push(root);
	    pp--;
	    
	    while (pp >= 0) {
	        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
	            prev = stack.pop();
	            ip--;
	        }
	        TreeNode newNode = new TreeNode(postorder[pp]);
	        if (prev != null) {
	            prev.left = newNode;
	        } else if (!stack.isEmpty()) {
	            TreeNode currTop = stack.peek();
	            currTop.right = newNode;
	        }
	        stack.push(newNode);
	        prev = null;
	        pp--;
	    }
	    
	    return root;
	}
}
