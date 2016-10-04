package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversalBinaryTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = levelOrder(root);
		for(List<Integer> layer : res){
			for(Integer node : layer){
				//System.out.print(node + " ");
			}
		}
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> nodes = new ArrayList<List<Integer>>();

		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) return nodes;

		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> layer = new ArrayList<Integer>();
			for(int i=0; i < size; i++) {
				root = queue.poll();
				layer.add(root.data);
				System.out.print(root.data + " ");
				if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
			}
			nodes.add(layer);
			System.out.println();
		}
		return nodes;
	}
}
