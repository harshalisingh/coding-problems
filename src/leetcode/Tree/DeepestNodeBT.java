package leetcode.Tree;

/*
 * Given a binary tree, Find the deepest node in it.
 */
public class DeepestNodeBT {
	int deepestlevel;
	int deepestNode;
	
	public int deepNode(TreeNode root) {
		find(root, 0);
		return deepestNode;
	}

	public void find(TreeNode root, int level) {
		if (root != null) {
			find(root.left, ++level);
			if (level > deepestlevel) {
				deepestNode = root.val;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.left.left = new TreeNode(100);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    
	    DeepestNodeBT dt = new DeepestNodeBT();
	    System.out.println(dt.deepNode(root));
	}
}

/*
 * Given a binary tree, Find the deep­est left node in it.
 */
class DeepestLeftLeaf {

	public int deepestLevel = 0;
	public int deepestLeftNode;

	public int deepLeft(TreeNode root) {
		find(root, 0, true);
		return deepestLeftNode;
	}

	public void find(TreeNode root, int level, boolean left) {
		if (root != null) {
			find(root.left, ++level, true);
			if (left && deepestLevel < level) {// check if it a left child and current level is greater than deepest level
				deepestLeftNode = root.val; // update the deepest left node
				deepestLevel = level;   // update the deepest level
			}
			find(root.right, level, false);
		}
	}
	
	
	
}
