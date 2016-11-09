package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderBinaryTreeTraversal {
	void iterativePostOrder(TreeNode root){
		if(root == null) return;
		Deque<TreeNode> s1 = new ArrayDeque<>();
		Deque<TreeNode> s2 = new ArrayDeque<>();
		
		s1.push(root);
		while(!s1.isEmpty()){
			root = s1.pop();
			s2.push(root);
			if(root.left != null) s1.push(root.left);
			if(root.right != null) s1.push(root.right);
		}
		
		while(!s2.isEmpty()){
			root = s2.pop();
			System.out.print(root.val);
		}
	}
	
	void recursivePostOrder(TreeNode root){
		if(root == null) return;
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.println(root.val);

	}
}
