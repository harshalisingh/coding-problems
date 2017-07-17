package leetcode.Tree;

/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree. 
 * Especially, this path can be either increasing or decreasing. On the other hand, the path can be in the child-Parent-child order, 
 * where not necessarily be parent-child order.
 * Time complexity : O(n). The whole tree is traversed only once.
 * Space complexity : O(n). The recursion goes upto a depth of n in the worst case.
 * https://leetcode.com/problems/longest-consecutive-sequence/#/description
 */
public class BTLongestConsecutiveSequenceII {
    int max = 0;  
    class Result {
        TreeNode node;
        int inr;
        int dcr;
    }  
    public int longestConsecutive(TreeNode root) {
    	longestPath(root);
        return max;
    }
    private Result longestPath(TreeNode root) {
        if (root == null) return null;
        
        //we obtain the length of the longest path for the left child of the current node using longestPath(root.left)
        Result left = longestPath(root.left);
        Result right = longestPath(root.right);
        
        //We start off by assigning both inr and dcr as 1 for the current node
        Result curr = new Result();
        curr.node = root;
        curr.inr = 1;
        curr.dcr = 1;
        
        /* Now, if the left child is just smaller than the current node, it forms a decreasing sequence with the current node. 
         * Thus, the dcr value for the current node is stored as the left child's dcr value + 1.
         * But, if the left child is just larger than the current node, it forms an incrementing sequence with the current node. 
         * Thus, we update the current node's inr value as left child's inr value + 1.
         */
        if (left != null) {
            if (root.val == left.node.val + 1) {
                curr.inr = Math.max(curr.inr, left.inr + 1);
            }
            else if (root.val == left.node.val - 1) {
                curr.dcr = Math.max(curr.dcr, left.dcr + 1);
            }
        }
        
        if (right != null) {
            if (root.val == right.node.val + 1) {
                curr.inr = Math.max(curr.inr, right.inr + 1);
            }
            else if (root.val == right.node.val - 1) {
                curr.dcr = Math.max(curr.dcr, right.dcr + 1);
            }
        }
        
        //Further, after we've obtained the final updated values of inr and dcr for a node, 
        //we update the length of the longest consecutive path found so far.
        max = Math.max(max, curr.inr + curr.dcr - 1);      
        return curr;
    }
}