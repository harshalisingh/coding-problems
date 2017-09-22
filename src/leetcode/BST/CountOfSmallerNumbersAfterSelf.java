package leetcode.BST;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	class Node {
		Node left, right;
		int val, count, dup = 1;
		public Node(int v, int c) {
			val = v;
			count = c;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		Node root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(nums[i], ans, root, i, 0);
		}
		return Arrays.asList(ans);
	}
	private Node insert(int num, Integer[] ans, Node node, int i, int preCount) {
		if (node == null) {
			node = new Node(num, 0);
			ans[i] = preCount;
		} else if (node.val == num) {
			node.dup++;
			ans[i] = preCount + node.count;
		} else if (node.val > num) {
			node.count++;
			node.left = insert(num, ans, node.left, i, preCount);
		} else {
			node.right = insert(num, ans, node.right, i, preCount + node.dup + node.count);
		}
		return node;
	}

	public static void main(String[] args){
		CountOfSmallerNumbersAfterSelf caller = new CountOfSmallerNumbersAfterSelf();
		int[] nums = {3, 7, 2, 2, 6, 1};
		List<Integer> ans = caller.countSmaller(nums);
		System.out.println(ans.toString());
	}
}
