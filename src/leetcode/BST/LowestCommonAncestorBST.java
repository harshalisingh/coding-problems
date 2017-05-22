package leetcode.BST;

import leetcode.Tree.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Just walk down from the whole tree's root as long as both p and q are in the same subtree 
 * (meaning their values are both smaller or both larger than root's).
 */
public class LowestCommonAncestorBST {
	/* Function to find LCA of n1 and n2. The function does not assume that both
    n1 and n2 are present in BST */
	TreeNode lca(TreeNode node, int n1, int n2) 
	{
		if (node == null)
			return null;

		if(node.val > Math.max(n1, n2))
			return lca(node.left, n1, n2);
		else if(node.val < Math.min(n1, n2))
			return lca(node.right, n1, n2);
		else if(find(node, n1) && find(node, n2)){
			return node;
		} else {
			return null;
		}

	}

	private boolean find(TreeNode node, int val) {
		if(node == null) return false;
		if(node.val == val) return true;
		if(val < node.val)
			return find(node.left, val);
		else
			return find(node.right, val);
	}
	
	
	public TreeNode lcaSimple(TreeNode root, int p, int q) {
		if (root.val > Math.max(p, q)) {
			return lca(root.left, p, q);
		} else if (root.val < Math.min(p, q)) {
			return lca(root.right, p, q);
		} else {
			return root;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(12);
		
		LowestCommonAncestorBST o = new LowestCommonAncestorBST();
		TreeNode ans = o.lcaSimple(root, 2, 6);
		System.out.println(ans.val);
	}

}
