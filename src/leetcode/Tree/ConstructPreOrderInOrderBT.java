package leetcode.Tree;

import java.util.Stack;

public class ConstructBinaryTree {
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
	        }
	    }
	    root.left = helperPreorderInorder(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helperPreorderInorder(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
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
