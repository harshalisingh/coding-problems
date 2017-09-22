package leetcode.BST;

import leetcode.Tree.TreeNode;

/** Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * https://www.youtube.com/watch?v=LR3K5XAWV5k
 */
public class RecoverBST {
	TreeNode firstStartPoint, lastEndPoint;
	TreeNode prevNode;
	
	public void recoverTree(TreeNode root) {
		traverse(root);
		int temp = firstStartPoint.val;
		firstStartPoint.val = lastEndPoint.val;
		lastEndPoint.val = temp;
	}

	public void traverse(TreeNode root) {
		if (root == null) return;

		traverse (root.left);

		if (prevNode != null) {
			if (prevNode.val   >  root.val) {
				if (firstStartPoint == null) {
					firstStartPoint = prevNode;
				}
				lastEndPoint = root;
			}
		}
		prevNode = root;

		traverse (root.right);   
	}
}
