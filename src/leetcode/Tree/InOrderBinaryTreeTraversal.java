package leetcode.Tree;

import java.util.Stack;

public class InOrderBinaryTreeTraversal {
	void iterativeInOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<>();

		while(root != null || !stack.isEmpty()){
	        while(root != null){
	            stack.push(root);
	            root = root.left;
	        }
	        root = stack.pop();
	        System.out.println(root.val);
	        root = root.right;
	        
	    }
	}

	void recursiveInOrder(TreeNode root){
		if(root == null) return;
		recursiveInOrder(root.left);
		System.out.println(root.val);
		recursiveInOrder(root.right);		
	}
}
