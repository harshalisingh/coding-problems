package leetcode.BST;

import leetcode.Tree.TreeNode;

/** Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
 * where largest means subtree with largest number of nodes in it.
 * https://leetcode.com/problems/largest-bst-subtree/#/description
 * Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
 */
public class LargestBSTSubtree {
	class Result{
        int size;
        TreeNode min;
        TreeNode max;
        boolean isBST;
        
        Result(int size, TreeNode min, TreeNode max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        Result res = traversal(root);
        return res.size;
    }
    
    private Result traversal(TreeNode root) {
        if (root == null) return new Result(0, null, null, true);
        
      //postorder traversal of tree. First visit left and right then
      //use information of left and right to calculate largest BST.
        Result left = traversal(root.left);
        Result right = traversal(root.right);
        
        
        if (left.isBST && right.isBST) {
            boolean checkL = true, checkR = true;
            if (left.max != null && root.val <= left.max.val) checkL = false;
            if (right.min != null && root.val >= right.min.val) checkR = false;
            
            //if we reach this point means subtree with this node as root is BST.
    		//Set isBST as true. Then set size as (size of left + size of right + 1).
    		//Set min and max to be returned to parent.
            if (checkL && checkR) {
                return new Result(left.size + right.size + 1, 
                		left.min == null ? root : left.min,            //if root.left is null then min == root else min of leftside
                				right.max == null ? root : right.max,  //if root.right is null then max == root else max of rightside
                						true);
            }
        }
        return new Result(Math.max(left.size, right.size), null, null, false);
    }
}
