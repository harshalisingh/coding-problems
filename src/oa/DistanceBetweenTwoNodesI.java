package oa;

import leetcode.Tree.TreeNode;

//http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
public class DistanceBetweenTwoNodesI {
	public int findDistance(TreeNode root, int n1, int n2) {
		int x = findLevel(root, n1);
		int y = findLevel(root, n2);
		int lcaVal = findLCA(root, n1, n2).val;
		int lcaDistance = findLevel(root, lcaVal);
		return (x + y) - 2 * lcaDistance;
	}
	
	private int findLevel(TreeNode root, int n1){
        if (root == null)
            return -1;
        if(root.val == n1)
            return 0;

        int level = findLevel(root.left, n1);

        if (level == -1)
            level = findLevel(root.right, n1);

        if(level != -1)
            return level + 1;

        return -1;
    }

	public TreeNode findLCA(TreeNode root, int n1, int n2) {
		if (root != null) {
			if (root.val == n1 || root.val == n2) {
				return root;
			}
			TreeNode left = findLCA(root.left, n1, n2);
			TreeNode right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			return left != null ? left : right;
		}
		return null;
	}

	public int Pathlength(TreeNode root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.val == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}
	
	

	public static void main(String[] args) throws java.lang.Exception {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.left.right.right = new TreeNode(45);
		DistanceBetweenTwoNodesI i = new DistanceBetweenTwoNodesI();
		System.out.println("Distance between 45 and 20 is : "
				+ i.findDistance(root, 45, 20));
	}
}
