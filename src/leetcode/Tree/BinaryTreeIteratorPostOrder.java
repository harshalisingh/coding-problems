package leetcode.Tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public interface BinaryTreeIteratorPostOrder extends Iterator<Integer> { 
	/** Returns the next integer a in the post-order traversal of the given binary tree.
	 * For example, given a binary tree below,
	 *       4
	 *      / \
	 *     2   6
	 *    / \ / \
	 *   1  3 5  7
	 * the outputs will be 1, 3, 2, 5, 7, 6, 4. 
	 */ 
	public Integer next(); 

	/** Return true if traversal has not finished; otherwise, return false. */ 
	public boolean hasNext();
}
class PostOrderBinaryTreeIteratorImpl implements BinaryTreeIteratorPostOrder {  
	Stack<TreeNode> stack = new Stack<TreeNode>();  

	/** find the first leaf in a tree rooted at cur and store intermediate nodes */  
	private void findNextLeaf(TreeNode cur) {  
		while (cur != null) {  
			stack.push(cur);  
			if (cur.left != null) {  
				cur = cur.left;  
			} else {  
				cur = cur.right;  
			}  
		}  
	}  

	/** Constructor */  
	public PostOrderBinaryTreeIteratorImpl(TreeNode root) {  
		findNextLeaf(root);  
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
		if (!stack.isEmpty()) {  
			TreeNode top = stack.peek();  
			if (res == top.left) {  
				findNextLeaf(top.right); // find next leaf in right sub-tree 
			}  
		}  

		return res.val;  
	}  

	@Override  
	public void remove() {  
		throw new UnsupportedOperationException("remove() is not supported.");  
	}  
}  
