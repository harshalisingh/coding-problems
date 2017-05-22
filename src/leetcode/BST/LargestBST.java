package leetcode.BST;

import leetcode.Tree.TreeNode;

/*
 *  * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
 * 
 * References:
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBST {
	public int largestBST(TreeNode root){
		MinMax m = largest(root);
		return m.size;
	}

	private MinMax largest(TreeNode root){
		//if root is null return min as Integer.MAX and max as Integer.MIN 
		if(root == null){
			return new MinMax();
		}

		//postorder traversal of tree. First visit left and right then
		//use information of left and right to calculate largest BST.
		MinMax leftMinMax = largest(root.left);
		MinMax rightMinMax =largest(root.right);

		MinMax m = new MinMax();

		//if either of left or right subtree says its not BST or the data
		//of this node is not greater/equal than max of left and less than min of right
		//then subtree with this node as root will not be BST. 
		//Return false and max size of left and right subtree to parent
		if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.val || rightMinMax.min <= root.val)){
			m.isBST = false;
			m.size = Math.max(leftMinMax.size, rightMinMax.size);
			return m;
		}

		//if we reach this point means subtree with this node as root is BST.
		//Set isBST as true. Then set size as size of left + size of right + 1.
		//Set min and max to be returned to parent.
		m.isBST = true;
		m.size = leftMinMax.size + rightMinMax.size + 1;

		//if root.left is null then set root.data as min else
		//take min of left side as min
		m.min = root.left != null ? leftMinMax.min : root.val;

		//if root.right is null then set root.data as max else
		//take max of right side as max.
		m.max = root.right != null ? rightMinMax.max : root.val;

		return m;
	}

	/**
	 * Object of this class holds information which child passes back
	 * to parent node.
	 */
	class MinMax{
		int min;
		int max;
		boolean isBST;
		int size ;

		MinMax(){
			min = Integer.MAX_VALUE; // For minimum value in right subtree
			max = Integer.MIN_VALUE; // For maximum value in left subtree	
			isBST = true;
			size = 0;    // for size of largest BST
		}

	}
}
