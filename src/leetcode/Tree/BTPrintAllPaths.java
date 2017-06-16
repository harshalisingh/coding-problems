package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return all root-to-leaf paths.
public class BTPrintAllPaths {
	
	//Short and Simple
	public List<String> binaryTreePaths1(TreeNode root) {
	    List<String> answer = new ArrayList<String>();
	    if (root != null) searchBT(root, "", answer);
	    return answer;
	}
	private void searchBT(TreeNode root, String path, List<String> answer) {
	    if (root.left == null && root.right == null) answer.add(path + root.val);
	    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
	    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
	}
	
//	-------------------------------------------------------------------------------------
	
	public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }
    private static void helper(TreeNode root, StringBuilder sb, List<String> res) {
        if(root == null) {
            return;
        }	
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(root.left, sb, res);
            helper(root.right, sb, res);
        }
        //System.out.println(sb.toString());
        sb.setLength(len);
    }
    
    public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		List<String> string = binaryTreePaths2(root);
		for(String s : string){
			System.out.println(s);
		}
	}
}
