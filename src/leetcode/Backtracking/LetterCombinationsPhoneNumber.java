package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 *
 */
public class LetterCombinationsPhoneNumber {
    static final String[] KEYS = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
    public static List<String> letterCombinationsIterative(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    ans.add("");
	    for(int i=0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : KEYS[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args){
		List<String> ans = letterCombinationsRecursive("23");
		for(String s : ans){
			System.out.println(s);
		}
	}
	
	public static List<String> letterCombinationsRecursive(String digits) {
	    List<String> res = new ArrayList<>();
	    if (digits == null || digits.length() == 0) return res;
	    StringBuilder sb = new StringBuilder();
	    combine(res, digits, sb, 0);
	    return res;
	}

	private static void combine(List<String> res, String digits, StringBuilder sb, int posn) {
	    if (posn == digits.length()) {
	        res.add(sb.toString());
	        return;
	    }
	    String letters = KEYS[digits.charAt(posn) - '0'];
	    //System.out.println(letters);
	    for (int i = 0; i < letters.length(); i++) {
	        int sbLen = sb.length();
	        combine(res, digits, sb.append(letters.charAt(i)), posn + 1);
	        sb.setLength(sbLen);
	    }
	}
}
