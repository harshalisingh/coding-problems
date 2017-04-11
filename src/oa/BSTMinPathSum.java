package oa;

public class BSTMinPathSum {
	public int getMinSum(Node root) {
		if (root == null) {
			return 0;
		}
		return getMinSum(root, 0, 0);
	}

	private int getMinSum(Node curr, int currSum, int max) {
		if (curr == null) {
			if (currSum > max) {
				max = currSum;
			}
			return max;
		}
		currSum += curr.val;
		max = Math.max(getMinSum(curr.left, currSum, max), getMinSum(curr.right, currSum, max));
		return max;
	}

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		BSTMinPathSum test = new BSTMinPathSum();
		Node root = new Node(3, new Node(2, null, null), new Node(4, null, null));
		System.out.println(test.getMinSum(root));
	}
}


