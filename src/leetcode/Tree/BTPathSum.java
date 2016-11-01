package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class BTPathSum {
	public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.data;

        return hasPathSumRecursive(root.left, sum - root.data) 
        		|| hasPathSumRecursive(root.right, sum - root.data);
    }
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
 
        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
        Deque<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.data);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.data);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.data);
            }
        }
 
        return false;
    }
}
