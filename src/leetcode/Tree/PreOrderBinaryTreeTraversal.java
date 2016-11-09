package leetcode.Tree;

import java.util.Stack;

public class PreOrderBinaryTreeTraversal {
	void iterativePreOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            System.out.println(root.val);
            if(root.right != null) s1.push(root.right);
            if(root.left != null) s1.push(root.left);
        }
	}
	
	void recursivePreOrder(TreeNode root){
		if(root == null) return;
		System.out.println(root.val);
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
		
	}
}
