package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Iterative BFS (Level Order Traversal)
public class SerializingBinaryTreeBFSIterative {
	private static final String delimiter = ",";
    private static final String NN = "#";
    
	public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
            	sb.append(NN).append(delimiter);
                continue;
            }
            sb.append(node.val).append(delimiter);
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(delimiter);
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if (!nodes[i].equals(NN)) {
                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
                parent.left = left;
                q.add(left);
            }
            if (!nodes[++i].equals(NN)) {
                TreeNode right = new TreeNode(Integer.valueOf(nodes[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    
    public static void main(String[] args){
    	SerializingBinaryTreeBFSIterative sbi = new SerializingBinaryTreeBFSIterative();
    	BinaryTreePreOrderTraversal bt = new BinaryTreePreOrderTraversal();
		
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(2);
    	root.right.left = new TreeNode(7);
    	String serialized = sbi.serialize(root);
    	TreeNode deserialized = sbi.deserialize(serialized);
    	bt.preOrder(deserialized);
    	
    }
}
