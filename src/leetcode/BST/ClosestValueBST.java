package leetcode.BST;

import leetcode.Tree.TreeNode;

/*
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.
 */
public class ClosestValueBST {
	int goal;
    double min = Double.MAX_VALUE;
 
    public int closestValueRecursive(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }
 
    public void helper(TreeNode root, double target){
        if(root==null)
            return;
 
        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val - target);
            goal = root.val;
        } 
 
        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
    
    public int closestValueIterative(TreeNode root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.val;
     
        while(root!=null){
            if(target > root.val){
     
                double diff = Math.abs(root.val - target);
                if(diff < min){
                    min = diff;
                    result = root.val;
                }
                root = root.right;
            }else if(target < root.val){
     
                double diff = Math.abs(root.val - target);
                if(diff < min){
                    min = diff;
                    result = root.val;
                }
                root = root.left;
            }else{
                return root.val;
            }
        }    
        return result;
    }
    
    
}
