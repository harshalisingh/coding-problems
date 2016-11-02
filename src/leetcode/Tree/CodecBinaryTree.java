package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

//Serialize and Deserialize a Tree - PreOrder Traversal
public class CodecBinaryTree {
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
	    if(root==null){
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    Deque<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    queue.add(root);
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	        if(t!=null){
	            sb.append(String.valueOf(t.data) + ",");
	            queue.add(t.left);
	            queue.add(t.right);
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb.toString());
	    return sb.toString();
	}
	 
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data==null || data.length()==0)
	        return null;
	 
	    String[] arr = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	 
	 
	    Deque<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	 
	    int i=1;
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	 
	        if(t==null)
	            continue;
	 
	        if(!arr[i].equals("#")){
	            t.left = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.left);
	 
	        }else{
	            t.left = null;
	            queue.offer(null);
	        }
	        i++;
	 
	        if(!arr[i].equals("#")){
	            t.right = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.right);
	 
	        }else{
	            t.right = null;
	            queue.offer(null);
	        }
	        i++;
	    }
	 
	    return root;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		serialize(root);
	}
}
