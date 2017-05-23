package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class ZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			if (result.size() % 2 == 0) {
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					levelList.add(curr.val);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}
			} else {
				Stack<Integer> stack = new Stack<Integer>();
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					stack.push(curr.val);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}

				while(!stack.isEmpty()) {
					levelList.add(stack.pop());
				}
			}
			result.add(levelList);
		}

		return result;
	}
}
