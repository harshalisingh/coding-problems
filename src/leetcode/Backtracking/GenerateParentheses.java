package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * n = 3
 * [ "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"  ]
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if(n <= 0)
			return res;
		backtrack(res, "", 0, 0, n);
		return res;
	}

	public void backtrack(List<String> res, String str, int open, int close, int n){       
		if(open + close == 2 * n){
			System.out.println(res.toString());
			res.add(str);
			return;
		}

		if(open < n)
			backtrack(res, str+"(", open+1, close, n);
		if(close < open)
			backtrack(res, str+")", open, close+1, n);
	}

	/*
	 * Using StringBuilder
	 */
	public List<String> generateParenthesisII(int n) {
		List<String> res = new ArrayList<>();
		helper(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
		if(open == n && close == n) {
			res.add(sb.toString());
			return;
		}

		if(open < n) {
			sb.append("(");
			helper(res, sb, open+1, close, n);
			sb.setLength(sb.length()-1);
		} 
		if(close < open) {
			sb.append(")");
			helper(res, sb, open, close+1, n);
			sb.setLength(sb.length()-1);
		}
	}

	public static void main(String[] args){
		GenerateParentheses gp = new GenerateParentheses();
		List<String> result = gp.generateParenthesis(3);
	}

}
