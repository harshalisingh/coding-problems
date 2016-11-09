package leetcode.Tree;

/*
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
 * where # represents a null node.
 * Given a string of comma separated values, 
 * verify whether it is a correct preorder traversal serialization of a binary tree. 
 * Find an algorithm without reconstructing the tree.
 */
public class VerifyPreorderSerializationBT {
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node: nodes) {
			diff -= 1; //every node has 1 indegree (1 parent)
			if (diff < 0) return false;
			if (!node.equals("#")) diff += 2; //every non-null node has 2 outdegree (2 children)
		}
		return diff == 0;
	}
}
