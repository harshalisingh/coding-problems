package leetcode.Tree;

import java.util.Stack;

public class InOrderBinaryTreeTraversal {
	void iterativeInOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		
		while(true){
			if(root != null){
				s1.push(root);
				root = root.left;
			} else {
				if(!s1.isEmpty()){
					root = s1.pop();
					System.out.println(root.data);
					root = root.right;
				}
			}
		}
	}
	
	void recursiveInOrder(TreeNode root){
		if(root == null) return;
		recursiveInOrder(root.left);
		System.out.println(root.data);
		recursiveInOrder(root.right);		
	}
}
