package leetcode.Tree;

/*
 * Given a binary tree, Find the deep­est node in it.
 */
public class DeepestNodeBT {
	int deepestlevel;
	int value;
	
	public int Deep(Node root) {
		find(root, 0);
		return value;
	}

	public void find(Node root, int level) {
		if (root != null) {
			find(root.left, ++level);
			if (level > deepestlevel) {
				value = root.data;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}
}
