package leetcode.Tree;

/*
 * https://leetcode.com/problems/construct-string-from-binary-tree/#/description
 */
public class ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t) {
		if (t == null) return "";

		String result = t.val + "";

		String left = tree2str(t.left);
		String right = tree2str(t.right);

		if (left == "" && right == "") return result;
		if (left == "") return result + "()" + "(" + right + ")";
		if (right == "") return result + "(" + left + ")";
		return result + "(" + left + ")" + "(" + right + ")";
	}

	public String tree2strII(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		helper(sb,t);
		return sb.toString();
	}
	public void helper(StringBuilder sb,TreeNode t){
		if(t == null)
			return;

		sb.append(t.val);
		if(t.left!=null || t.right!=null){
			sb.append("(");
			helper(sb,t.left);
			sb.append(")");
			if(t.right!=null){
				sb.append("(");
				helper(sb,t.right);
				sb.append(")");
			}
		}
	}
}
