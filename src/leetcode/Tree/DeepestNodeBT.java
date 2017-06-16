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
