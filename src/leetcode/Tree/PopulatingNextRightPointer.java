package leetcode.Tree;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointer {
	public void connectRecursive(TreeLinkNode root) {
		if(root == null)
			return;

		if(root.left != null){
			root.left.next = root.right;
			if(root.next != null)
				root.right.next = root.next.left;
		}

		connectRecursive(root.left);
		connectRecursive(root.right);
	}
	
	/*
	 * O(1) memory + O(n) time
	 */
	public void connectIterative(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}
