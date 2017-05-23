package leetcode.Tree;

/*
 * Balanced Tree is defined to be a tree such that the heights of the two subtrees 
 * of any node never differ by more than one.
 */
public class IsBalancedBinaryTree {
	//Height of a Binary Tree
	int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		else{
			return  (1+ Math.max(getHeight(root.left), getHeight(root.right)));
		}
	}

	//InEfficient : getHeight is called repeatedly on each node.
	//Runtime O(N log N)
	boolean isBalancedSlow(TreeNode root){
		if(root == null) return true;

		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1){
			return false;
		} else {
			return isBalancedSlow(root.left) && isBalancedSlow(root.right);
		}
	}

	//If the subtree is balanced, then checkHeight will return actual height of the subtree.
	//If subtree is not balanced, then checkHeight will return an error code.
	boolean isBalancedFast(TreeNode root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private int checkHeight(TreeNode root) {
		if(root == null) return 0;

		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //Pass Error up

		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //Pass Error up

		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return Integer.MIN_VALUE; //Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
