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
        backtrack(0, 0, n, res, "");
        return res;
    }
    
    public void backtrack( int open, int close, int n, List<String> res, String str){       
        if(open + close == 2 * n){
            res.add(str);
            return;
        }
        
        if(open < n)
            backtrack(open+1, close, n, res, str+"(");
        if(close < open)
            backtrack(open, close+1, n, res, str+")");
    }

}
