package epi.BinaryTree;

//Time Complexity : O(n)
//Space Complexity: O(h)
public class IsSymmetricBinaryTree {
	public static boolean isSymmetric(BinaryTreeNode<Integer> root){
		return (root == null) || checkSymmetric(root.left, root.right);		
	}
	
	private static boolean checkSymmetric(BinaryTreeNode<Integer> subtree1, BinaryTreeNode<Integer> subtree2) {
		if(subtree1 == null && subtree2 == null)
			return true;
		else if(subtree1 != null && subtree2 != null){
			return (subtree1.data == subtree2.data)
					&& checkSymmetric(subtree1.left, subtree2.right)
					&& checkSymmetric(subtree1.right, subtree2.left);
		}
		return false;
	}
}
