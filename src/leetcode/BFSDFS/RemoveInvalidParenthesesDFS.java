package leetcode.BFSDFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesesDFS {
	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<>();
		remove(s, ans, 0, 0, new char[]{'(', ')'});
		return ans;
	}

	public void remove(String s, List<String> ans, int start, int lastRemove,  char[] par) {
		int stack = 0;
		for (int i = start; i < s.length(); ++i) {
			if (s.charAt(i) == par[0]) stack++;
			if (s.charAt(i) == par[1]) stack--;
			if (stack >= 0) continue;

			//if stack < 0
			for (int j = lastRemove; j <= i; ++j) {
				if (s.charAt(j) == par[1] && (j == lastRemove || s.charAt(j - 1) != par[1])) {

					//This is for duplication when dealing with case like '())'
					//noted that you are trying out every possible remove of excessive par[1]
					//so in the above case, both ")" will be checked, but the later one shoudn't 
					//matter.
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
				}	               
			}

			//When you are at this point, stack must < 0, so you have no reason to 
			//Check with the reverse version. So you simply return.
			return;
		}

		//When you are at this point, you only know stack must >= 0.
		//And you only finished left to right checked, with deleting the invalid 
		//parenthesis from left "()())()" ==> you only delete s[1] and checked (())()
		//you haven't find the case of delete s[4] instead. 
		//So at this point, you would need to do the reverse version for the 
		//right to left check!
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') {    // finished left to right

			//Since we do the reverse anyway, if par[0] is "(", 
			//This will be the case we just checked left to right
			//But not yet right to left
			remove(reversed, ans, 0, 0, new char[]{')', '('});
		}

		else {   // finished right to left

			//We've checked right to left also.
			//And since we reverse string anyway above, we are safe 
			//to put the s into answer.

			//** The tricky part is that when we are here, the s must
			//satisfy count of '(' >=  count of ')'
			//as well as count of ')' >= count of '('
			//which means it has '(' == ')', and will be valid answer
			ans.add(reversed);
		}
	}
	
	public static void main(String[] args){
		RemoveInvalidParenthesesDFS rip = new RemoveInvalidParenthesesDFS();
		List<String> result = rip.removeInvalidParentheses("(a)())()");
	}
}
