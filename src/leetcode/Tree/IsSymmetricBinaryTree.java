package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree, check whether it is a mirror of itself.
 * Time Complexity : O(n)
 * Space Complexity: O(h)
 */
public class IsSymmetricBinaryTree {
	public static boolean isSymmetric(TreeNode root){
		return (root == null) || checkSymmetric(root.left, root.right);		
	}
	
	private static boolean checkSymmetric(TreeNode subtree0, TreeNode subtree1) {
		if(subtree0 == null && subtree1 == null)
			return true;
		else if(subtree0 != null && subtree1 != null){
			return (subtree0.val == subtree1.val)
					&& checkSymmetric(subtree0.left, subtree1.right)
					&& checkSymmetric(subtree0.right, subtree1.left);
		}
		return false;
	}
	
	
	/* function to check if the tree is Symmetric */
    public boolean isSymmetricIterative(TreeNode root)
    {
        /* This allows adding null elements to the queue */
        Queue<TreeNode> q = new LinkedList<TreeNode>();
 
        /* Initially, add left and right nodes of root */
        q.add(root.left);
        q.add(root.right);
 
        while (!q.isEmpty())
        {
            /* remove the front 2 nodes to
              check for equality */
        	TreeNode tempLeft = q.remove();
        	TreeNode tempRight = q.remove();
 
            /* if both are null, continue and chcek
               for further elements */
            if (tempLeft==null && tempRight==null)
                continue;
 
            /* if only one is null---inequality, retun false */
            if ((tempLeft==null && tempRight!=null) ||
                (tempLeft!=null && tempRight==null))
                return false;
 
            /* if both left and right nodes exist, but
               have different values-- inequality,
               return false*/
            if (tempLeft.val != tempRight.val)
                return false;
 
            /* Note the order of insertion of elements
               to the queue :
               1) left child of left subtree
               2) right child of right subtree
               3) right child of left subtree
               4) left child of right subtree */
            q.add(tempLeft.left);
            q.add(tempRight.right);
            q.add(tempLeft.right);
            q.add(tempRight.left);
        }
 
        /* if the flow reaches here, return true*/
        return true;
    }
    
    /*
     * Create Mirror of Binary Tree
     */
    TreeNode mirror(TreeNode node)
    {
        if (node == null)
            return node;
 
        /* do the subtrees */
        TreeNode left = mirror(node.left);
        TreeNode right = mirror(node.right);
 
        /* swap the left and right pointers */
        node.left = right;
        node.right = left;
 
        return node;
    }
}
