package leetcode.Tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public interface BinaryTreeIteratorInOrder extends Iterator<Integer> { 
	/** Returns the next integer a in the in-order traversal of the given binary tree.
	 * For example, given a binary tree below,
	 *       4
	 *      / \
	 *     2   6
	 *    / \ / \
	 *   1  3 5  7
	 * the outputs will be 1, 2, 3, 4, 5, 6, 7. 
	 */ 
	public Integer next(); 

	/** Return true if traversal has not finished; otherwise, return false.
	 */ 
	public boolean hasNext();
}
class InOrderBinaryTreeIteratorImpl implements BinaryTreeIteratorInOrder {  
	Stack<TreeNode> stack = new Stack<TreeNode>();  

	/** Push node cur and all of its left children into stack */  
	private void pushLeftChildren(TreeNode cur) {  
		while (cur != null) {  
			stack.push(cur);  
			cur = cur.left;  
		}  
	}  

	/** Constructor */  
	public InOrderBinaryTreeIteratorImpl(TreeNode root) {  
		pushLeftChildren(root);  
	}  

	/** {@inheritDoc} */  
	@Override  
	public boolean hasNext() {  
		return !stack.isEmpty();  
	}  

	/** {@inheritDoc} */  
	@Override  
	public Integer next() {  
		if (!hasNext()) {  
			throw new NoSuchElementException("All nodes have been visited!");  
		}  

		TreeNode res = stack.pop();  
		pushLeftChildren(res.right);  

		return res.val;  
	}  

	@Override  
	public void remove() {  
		throw new UnsupportedOperationException("remove() is not supported.");  
	}  
}  

