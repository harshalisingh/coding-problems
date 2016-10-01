package leetcode.Tree;

import java.util.Stack;

public class PostOrderBinaryTreeTraversal {
	void iterativePostOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		while(!s1.empty()){
			root = s1.pop();
			s2.push(root);
			if(root.left != null) s1.push(root.left);
			if(root.right != null) s1.push(root.right);
		}
		
		while(!s2.isEmpty()){
			root = s2.pop();
			System.out.print(root.data);
		}
	}
	
	void recursivePostOrder(TreeNode root){
		if(root == null) return;
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.println(root.data);

	}
}
