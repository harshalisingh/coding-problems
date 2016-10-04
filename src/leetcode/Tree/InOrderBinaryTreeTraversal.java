package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class InOrderBinaryTreeTraversal {
	void iterativeInOrder(TreeNode root){
		if(root == null) return;
		Deque<TreeNode> s1 = new ArrayDeque<>();

		while(true){
			if(root != null){
				s1.push(root);
				root = root.left;
			} else {
				if(s1.isEmpty()){
					break;
				}
				root = s1.pop();
				System.out.println(root.data);
				root = root.right;
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
