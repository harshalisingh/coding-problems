package leetcode.Tree;

public class PrintLeafNodes {
	public static void printLeafNodes(TreeNode t)
	{
		if(t == null)       
			return;
		if(t.left == null && t.right == null)      
			System.out.println(t.val); 
		printLeafNodes(t.left); 
		printLeafNodes(t.right);      
	}
}
