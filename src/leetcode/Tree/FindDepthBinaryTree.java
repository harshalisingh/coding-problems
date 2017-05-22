package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Harshali
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * There are two conventions to define height of Binary Tree
 * 1) Number of nodes on longest path from root to the deepest node.
 * 2) Number of edges on longest path from root to the deepest node.
 * 
 * In this post, the first convention is followed
 *
 */

public class FindDepthBinaryTree {

	//Find the Maximum Depth OR Height of a Binary Tree
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else{
			return  (1+ Math.max(maxDepth(root.left), maxDepth(root.right)));
		}
	}
	
	//Height of a Binary Tree
	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		else{
			return  (1+ Math.max(height(root.left), height(root.right)));
		}
	}
	

	//Using Level Order Traversal (BFS)
	public static int maxDepthItr(TreeNode root) {
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
	
	//Min Depth of a Binary Tree
	//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.s
	public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
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
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(maxDepthItr(root));
	}

}
