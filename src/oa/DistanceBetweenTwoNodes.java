package oa;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Tree.TreeNode;

public class DistanceBetweenTwoNodes {
	public int pIndex = 0;
	public int findDistanceBetweenTwoNodes(int[] values, int n, int node1, int node2){
		TreeNode bst = constructTree(values, values[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		//levelOrderPrint(bst);
		int distance = getDistance(bst, new TreeNode(node1), new TreeNode(node2));
		return distance;
	}
	public void levelOrderPrint(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) System.out.print("");

		queue.offer(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			if(root != null){
				System.out.print(root.val + " ");
				if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
			}
		}
	}

	private TreeNode constructTree(int[] preorder, int data, int min, int max) {
		if (pIndex < preorder.length) {
			if (preorder[pIndex] > min && preorder[pIndex] < max) {
				TreeNode root = new TreeNode(data);
				pIndex++;
				if (pIndex < preorder.length) {
					// nodes lies between min and data will create left subtree
					root.left = constructTree(preorder, preorder[pIndex], min,
							data);
					// nodes lies between data and max will create right subtree
					root.right = constructTree(preorder, preorder[pIndex],
							data, max);
				}
				return root;
			}
		}
		return null;
	}
	private int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null || node1 == null || node2 == null)
			return -1;
		TreeNode ancestor = lcaBST(root, node1, node2);
		//System.out.println("ancestor " + ancestor.val);
		int lcaDistance = pathLength(root, ancestor.val) - 1; 
		int depth2 = pathLength(root, node1.val) - 1; 
		int depth3 = pathLength(root, node2.val) - 1; 
		//System.out.println(lcaDistance + ", " + depth2 + ", " + depth3);
		
		if(depth2 == -1 || depth3 == -1)
			return -1;
		return depth2 + depth3 - 2 * lcaDistance;

	}

	private TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val)) {
            return lcaBST(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lcaBST(root.right, p, q);
        } else {
            return root;
        }
    }

	private int getDepth(TreeNode curr, TreeNode target) {
		if (curr == null)
			return -1;
		if (curr == target)
			return 0;
		int left = getDepth(curr.left, target);
		int right = getDepth(curr.right, target);
		if (left == -1 && right == -1)
			return -1;
		return left == -1? right + 1: left + 1;

	}
	
	private int pathLength(TreeNode root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.val == n1) || (x = pathLength(root.left, n1)) > 0
					|| (x = pathLength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	
	public static void main(String[] args){
		DistanceBetweenTwoNodes db = new DistanceBetweenTwoNodes();
		int[] input = {5,3,1,2,4,6};
		int n = 6;
		int node1 = 8, node2 = 7;
		System.out.println(db.findDistanceBetweenTwoNodes(input, n, node1, node2));
	}
}
