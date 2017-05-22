package leetcode.BST;

import leetcode.Tree.TreeNode;

/*
 * Time Complexity: O(n)
 * T(n) = 2T(n/2) + C
   T(n) -->  Time taken for an array of size n
   C   -->  Constant (Finding middle of array and linking root to left 
                      and right subtrees take constant time) 
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
}
