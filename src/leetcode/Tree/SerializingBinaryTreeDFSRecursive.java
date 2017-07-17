package leetcode.Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Preorder Traversal - DFS Recursive
public class SerializingBinaryTreeDFSRecursive {
	private static final String delimiter = ",";
    private static final String NN = "#";
    
	public String serializeTree(TreeNode root){
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private void serialize(TreeNode node, StringBuilder sb){
		if (node == null) {
			sb.append(NN).append(delimiter);
		} else {
			sb.append(node.val).append(delimiter);
			serialize(node.left, sb);
			serialize(node.right, sb);
		}
	}

	 // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	//we use a Queue to store the pre-order traversal
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
    public static void main(String[] args){
    	SerializingBinaryTreeDFSRecursive obj = new SerializingBinaryTreeDFSRecursive();
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
    	
    	String serializedTree = obj.serializeTree(root);
    	System.out.println("Serialized tree: " + serializedTree);
    	
    	TreeNode deserializedTree = obj.deserialize(serializedTree);
    	
    	System.out.println("Deserialized Pre-order tree:");
		bt.preOrder(deserializedTree);
    }
}
