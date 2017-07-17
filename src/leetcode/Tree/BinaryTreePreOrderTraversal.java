package leetcode.Tree;

import java.util.Stack;

public class BinaryTreePreOrderTraversal {
	public void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/* Iterative Preorder Traversal
	 * This runs in time O(n) and use O(h) spaces.
	 * Use this!!
	 */
	public void preOrderItr(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.print(root.val + " ");
			if(root.right != null){
				stack.push(root.right);
			}
			if(root.left!= null){
				stack.push(root.left);
			}
		}
	}
	
	/* Preorder is simpler than inorder. Basically,
	 * Walk down the left tree to the bottom, visit each node and then push it into stack;
	 * Pop out a node from stack (the last visited);
	 * If it has right subtree, go to step 1 and repeat the same process on the subtree;
	 * If not, go to step 2 and repeat.
	 */
	public void preOrderIterative(TreeNode root) {   
		Stack<TreeNode> stack = new Stack<TreeNode>();  
		TreeNode cur = root;  
		// find the left-most node  
		while (cur != null) {  
			System.out.print(cur.val + " ");
			stack.push(cur);  
			cur = cur.left;  
		}  
		while (!stack.empty()) {  
			cur = stack.pop();  
			// go to the right subtree  
			cur = cur.right;  
			// find the left-most node  
			while (cur != null) {  
				System.out.print(cur.val + " ");
				stack.push(cur);  
				cur = cur.left;  
			}  
		} // while-stack-empty   
	}
	
	public static void main(String[] args){
		BinaryTreePreOrderTraversal bt = new BinaryTreePreOrderTraversal();
		
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(2);
    	root.right.left = new TreeNode(7);
    	bt.preOrder(root);
    	System.out.println();
    	bt.preOrderItr(root);
    	System.out.println();
    	bt.preOrderIterative(root);
	}
}
