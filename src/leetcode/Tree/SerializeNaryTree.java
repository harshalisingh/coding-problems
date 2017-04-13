package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;

/*
 * http://www.geeksforgeeks.org/serialize-deserialize-n-ary-tree/
 */
public class SerializeNaryTree {
	static class NNode
    {
    	char c;
    	List<NNode> list = new LinkedList<NNode>();
    	int index = 0;
    	public NNode(char c)
    	{
    		this.c = c;
    	}
    	
    	public void addChild(NNode node)
    	{
    		list.add(index++, node);
    	}
    }

	// This function stores the given N-ary tree in a String pointed by sb	
	public static String serializeNaryTree(NNode root){
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	// This function stores the given N-ary tree in a file pointed by fp
	public static void serialize(NNode root, StringBuilder sb)
	{
	    // Base case
	    if (root == null) return;
	 
	    // Else, store current node and recur for its children
	    sb.append(root.c);
	    for (NNode temp : root.list) {
	    	serialize(temp, sb);
		}
	    // Store marker at the end of children
	    sb.append(")");
	}
	
	
	public static NNode deserializeNaryTree(String str)
    {
    	new NNode(str.charAt(0));
    	NNode root = deserialize(str);
    	return root;
    }
    private static int currentIndex = 0;
	private static NNode deserialize(String str)
	{
		if (currentIndex >= str.length())
		{
			return null;
		}
		else if (str.charAt(currentIndex) == ')')
		{
			return null;
		}
 
		NNode root = new NNode(str.charAt(currentIndex));
		while(currentIndex < str.length())
		{
			currentIndex++;
			NNode child = deserialize(str);
			if (child == null)
				break;
			root.addChild(child);
 
		}			
		return root;
	}

	public static void main(String[] args){
		
		String input = "541)6))37))28)9)))";
		NNode naryTree =  deserializeNaryTree(input);
		String serialized = serializeNaryTree(naryTree);
		System.out.println(serialized);
		System.out.println(input);
		System.out.println(serialized.equals(input));
	}
}
