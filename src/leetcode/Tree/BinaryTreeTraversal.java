package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class BinaryTreeTraversal {

	public void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	

	public void postOrder(TreeNode root){
		if(root == null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	/* Iterative Inorder Traversal
	 * Since we visit each node once, this algorithm runs in time O(n) using O(h) (worst-case O(n)) spaces, 
	 * where h is the depth of the tree.
	 */
	void inOrderItr(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			System.out.println(root.val);
			root = root.right;	        
		}
	}

	/* Function to traverse binary tree without recursion and without stack.
	 * Go to the left most node, and follow right pointers to complete the traversal.
	 * During the traversal, Morris algorithm then fix the modified right pointers and set them back to null.
	 * http://n00tc0d3r.blogspot.com/search/label/BinaryTree */
	public void inorderMorris(TreeNode root) {  
		TreeNode cur = root;  

		while (cur != null) {  
			if (cur.left != null) {  
				TreeNode pre = cur.left;  
				while (pre.right != null && pre.right != cur) {  
					pre = pre.right;  
				}  
				if (pre.right == null) { // set right to successor  
					pre.right = cur;  
					cur = cur.left;  
				} else { // visit and revert the change  
					pre.right = null;  
					System.out.println(cur.val); 
					cur = cur.right;  
				}  
			} else { // visit and move to successor 
				System.out.println(cur.val);  
				cur = cur.right;  
			}  
		}  
	}  

	

	//Iterative Postorder Traversal
	public void postOrderItr(TreeNode root){
		Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
		Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			root = stack1.pop();
			if(root.left != null){
				stack1.push(root.left);
			}
			if(root.right != null){
				stack1.push(root.right);
			}
			stack2.push(root);
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().val + " ");
		}
	}

	//Iterative Postorder Traversal - One Stack
	public void postOrderItrOneStack(TreeNode root){
		TreeNode current = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(current != null || !stack.isEmpty()){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else{
				TreeNode temp = stack.peek().right; //check for right subtree
				if (temp == null) {   //right subtree does not exist, okay to pop the element which is our root
					temp = stack.poll();
					System.out.print(temp.val + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) { //current popped element is a right child of some node
						temp = stack.poll();
						System.out.print(temp.val + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(8);
		root.left.right.right.left = new TreeNode(9);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(12);

		BinaryTreeTraversal bt = new BinaryTreeTraversal();
		bt.inOrder(root);

	}
}
