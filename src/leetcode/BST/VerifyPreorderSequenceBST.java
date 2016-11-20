package leetcode.BST;

/*
 * Given an array of numbers, verify whether it is the correct 
 * preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 */
public class VerifyPreorderSequenceBST {
	public boolean verifyPreorder(int[] preorder) {
	    return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean verify(int[] preorder, int start, int end, int min, int max) {
	    if (start > end) {
	        return true;
	    }
	    int root = preorder[start];
	    if (root > max || root < min) {
	        return false;
	    }
	    
	    int rightIndex = start;
	    while (rightIndex <= end && preorder[rightIndex] <= root) {
	        rightIndex++;
	    }
	    return verify(preorder, start + 1, rightIndex - 1, min, root) 
	    	&& verify(preorder, rightIndex, end, root, max);
	}
}
