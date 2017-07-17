package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class SerializingBinaryTreeDFSIterative {
	private static final String delimiter = ",";
	private static final String NN = "#";

	// Encodes a tree to a single string.  
	public String serialize(TreeNode root) {  
		StringBuilder sb = new StringBuilder();   
		Deque<TreeNode> stack=new LinkedList<>();  
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				sb.append(cur.val).append(delimiter);
				stack.push(cur);
				cur = cur.left;
			}
			else {
				sb.append(NN).append(delimiter);
				cur = stack.pop();
				cur = cur.right;
			}
		} 
		return sb.toString();  
	} 
	
	// Decodes your encoded data to tree.  
	public TreeNode deserialize(String data) {  
		if (data.length() == 0) return null;  
		
		String[] node=data.split(delimiter);  
		int n = node.length;  
		Deque<TreeNode> stack = new LinkedList<>();  
		TreeNode root = new TreeNode(Integer.valueOf(node[0]));  
		TreeNode cur = root;  
		stack.push(cur);  
		int i = 1;  
		while (i < n) {  
			while (i < n && !node[i].equals(NN)) {  
				cur.left = new TreeNode(Integer.valueOf(node[i++]));  
				cur = cur.left;  
				stack.push(cur);  
			}  
			
			while (i < n && node[i].equals(NN)) {  
				cur = stack.pop();  
				i++;  
			}  
			if (i < n) {  
				cur.right = new TreeNode(Integer.valueOf(node[i++]));  
				cur = cur.right;  
				stack.push(cur);  
			}  
		}  
		return root;  
	}

	public static void main(String[] args){
		SerializingBinaryTreeDFSIterative obj = new SerializingBinaryTreeDFSIterative();
		BinaryTreePreOrderTraversal bt = new BinaryTreePreOrderTraversal();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(7);

		System.out.println("Pre-order tree:");
		bt.preOrder(root);
		System.out.println();

		String serializedTree = obj.serialize(root);
		System.out.println("Serialized tree: " + serializedTree);

		TreeNode deserializedTree = obj.deserialize(serializedTree);

		System.out.println("Deserialized Pre-order tree:");
		bt.preOrder(deserializedTree);
	}
}
