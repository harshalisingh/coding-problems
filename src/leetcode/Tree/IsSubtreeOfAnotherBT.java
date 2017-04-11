package leetcode.Tree;

public class IsSubtreeOfAnotherBT {
	/* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(TreeNode T, TreeNode S) 
    {
        /* base cases */
        if (S == null) 
            return true;
  
        if (T == null)
            return false;
  
        /* Check the tree with root as current node */
        if (isSameTree(T, S)) 
            return true;
  
        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
