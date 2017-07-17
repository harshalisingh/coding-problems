package leetcode.BST;
import java.util.Stack;
import leetcode.Tree.TreeNode;

/** Convert a given Binary Search Tree to Sorted Doubly Linked List
 * http://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 */
public class ConvertBSTToDoublyLinkedList {

	static // 'head' - reference to head node of created double linked list
	TreeNode head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BSTToDLL(TreeNode root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BSTToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			(head).left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BSTToDLL(root.left);
	}

	/* Function to print nodes in a given doubly linked list */
	void printList(TreeNode node) {
		TreeNode lastNode = null;
		while (node != null) {
			System.out.print(node.val + " ");
			lastNode = node;
			node = node.right;
		}

		System.out.println();
		System.out.println("Now in reverse order");
		node = lastNode;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.left;
		}
	}



	/*
    Thoughts:
    Inorder with 1 stack: peek add left till end, pop and add, then push right node.

    Everytime when pop out a node and add, make it a new doubllistnode
        dNode.next = curr
        curr.pre = dNode.next
        dNode = dNode.next

    boarder case: if null, return a null.
	 */
	public DoubleListNode bstToDoublyListIterative(TreeNode root) {  
		if (root == null) {
			return null;
		}
		//Init stack
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;    
		stack.push(node);
		//Create DoublyListNode header
		DoubleListNode dummy = new DoubleListNode(0);
		DoubleListNode dNode = dummy;


		while(!stack.isEmpty()) {
			while (node != null && node.left != null) {
				stack.push(node.left);
				node = node.left;
			}
			//add node
			node = stack.pop();
			DoubleListNode curr = new DoubleListNode(node.val);
			dNode.next = curr;
			curr.prev = dNode;
			dNode = dNode.next;

			//check right node and add to stack
			node = node.right;
			if (node != null) {
				stack.push(node);
			}  
		}

		return dummy.next;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);

		ConvertBSTToDoublyLinkedList caller = new ConvertBSTToDoublyLinkedList();
		// convert to DLL
		caller.BSTToDLL(root);

		// Print the converted List
		caller.printList(head);

	}
}
class DoubleListNode {
	public int val;
	public DoubleListNode next;
	public DoubleListNode prev;
	DoubleListNode(int x) { 
		val = x; 
		DoubleListNode next, prev = null;
	}
}
