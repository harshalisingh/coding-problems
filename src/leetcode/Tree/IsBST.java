package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree, return true if it is binary search tree else return false.
 * 
 * Solution
 * Keep min, max for every recursion. Initial min and max is very small and very larger
 * number. Check if root.data is in this range. When you go left pass min and root.data and 
 * for right pass root.data and max.
 * 
 * Time complexity is O(n) since we are looking at all nodes.
 * 
 * Test cases:
 * Null tree
 * 1 or 2 nodes tree
 * Binary tree which is actually BST
 * Binary tree which is not a BST
 */
public class IsBST {

    public boolean isBST(TreeNode root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val > max){
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }


    public boolean isBSTIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int prev = Integer.MIN_VALUE;
        int current;
        while ( true ) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pollFirst();
                current = node.val;
                if (current < prev) {
                    return false;
                }
                prev = current;
                node = node.right;
            }
        }
        return true;
    }
}
