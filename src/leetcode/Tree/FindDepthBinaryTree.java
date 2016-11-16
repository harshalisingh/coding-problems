package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Harshali
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 */

public class FindDepthBinaryTree {

	//Find the Maximum Depth OR Height of a Binary Tree
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else{
			return  (1+ Math.max(maxDepth(root.left), maxDepth(root.right)));
		}
	}
	
	public int minDepth(TreeNode root) {
        if (root == null)	return 0;
        if (root.left == null)	return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
	
	//Using Level Order Traversal (BFS)
	public int maxDepthItr(TreeNode root) {
	    if (root == null){
	        return 0;
	    }
	    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
	    queue.offer(root);
	    int count = 0;
	    while (!queue.isEmpty()){
	        int size = queue.size(); // determine the loop size
	        for (int i = 0; i< size; i++){
	            root = queue.poll();
	            if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
	        }
	        count ++;
	    }
	    return count;
	}
	
	//Using Level Order Traversal (BFS)
	public int minDepthItr(TreeNode root) {
	    if (root == null){
	        return 0;
	    }
	    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
	    queue.offer(root);
	    int depth = 1;
	    while (!queue.isEmpty()){
	        int size = queue.size(); // determine the loop size
	        for (int i = 0; i< size; i++){
	            root = queue.poll();
	            if (root.left == null && root.right == null){
	                return depth;
	            }
	            if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
	        }
	        depth ++;
	    }
	    return depth;
	}
	
	

}
