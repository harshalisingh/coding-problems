package epi.BinaryTree;

//Time Complexity : O(n)
//Space Complexity: O(h)
public class IsSymmetricBinaryTree {
	public static boolean isSymmetric(BinaryTreeNode<Integer> root){
		return (root == null) || checkSymmetric(root.left, root.right);		
	}
	
	private static boolean checkSymmetric(BinaryTreeNode<Integer> subtree0, BinaryTreeNode<Integer> subtree1) {
		if(subtree0 == null && subtree1 == null)
			return true;
		else if(subtree0 != null && subtree1 != null){
			return (subtree0.data == subtree1.data)
					&& checkSymmetric(subtree0.left, subtree1.right)
					&& checkSymmetric(subtree0.right, subtree1.left);
		}
		return false;
	}
}
