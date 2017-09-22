package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static void levelOrderPrint(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) System.out.print("");

		queue.offer(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			System.out.print(root.val + " ");
			if(root.left != null) queue.offer(root.left);
			if(root.right != null) queue.offer(root.right);
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) return result;

		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> layer = new ArrayList<Integer>();
			for(int i=0; i < size; i++) {
				root = queue.poll();
				layer.add(root.val);
				if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
			}
			result.add(layer);
		}
		return result;
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(9);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(10);

		levelOrderPrint(root);

		List<List<Integer>> res = levelOrder(root);
		for(List<Integer> layer : res){
			System.out.println(layer.toString());
		}
	}
}
