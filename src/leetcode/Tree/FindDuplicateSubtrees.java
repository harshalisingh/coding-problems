package leetcode.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Find Duplicate Subtrees
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
 * you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new LinkedList<>();
		postorder(root, new HashMap<>(), res);
		return res;
	}

	public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
		if (cur == null) return "#";  
		String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
		if (map.containsKey(serial) && map.get(serial) == 1) res.add(cur);
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}
}
