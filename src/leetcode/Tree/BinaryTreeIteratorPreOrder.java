package leetcode.Tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public interface BinaryTreeIteratorPreOrder extends Iterator<Integer> { 
	/** Returns the next integer a in the pre-order traversal of the given binary tree.
	 * For example, given a binary tree below,
	 *       4
	 *      / \
	 *     2   6
	 *    / \ / \
	 *   1  3 5  7
	 * the outputs will be 4, 2, 1, 3, 6, 5, 7. 
	 */ 
	public Integer next(); 

	/** Return true if traversal has not finished; otherwise, return false.
	 */ 
	public boolean hasNext();
}
class PreOrderBinaryTreeIteratorImpl implements BinaryTreeIteratorPreOrder {  
	Stack<TreeNode> stack = new Stack<TreeNode>();  

	/** Constructor */  
	public PreOrderBinaryTreeIteratorImpl(TreeNode root) {  
		if (root != null) {  
			stack.push(root); // add to end of queue 
		}  
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

		TreeNode res = stack.pop(); // retrieve and remove the head of queue 
		if (res.right != null) stack.push(res.right);  
		if (res.left != null) stack.push(res.left);  

		return res.val;  
	}  

	@Override  
	public void remove() {  
		throw new UnsupportedOperationException("remove() is not supported.");  
	}  
}  
