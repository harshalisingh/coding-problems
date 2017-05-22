package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a function to generate the generalized abbreviations of a word.
 * https://discuss.leetcode.com/topic/32270/java-backtracking-solution/11
 * Time Complexity: O(n^2)
 * 
 * https://discuss.leetcode.com/topic/32765/java-14ms-beats-100
 * 
 * For each char c[i], either abbreviate it or not.
 * 
 * Abbreviate: count accumulate num of abbreviating chars, but don't append it yet.
 * Not Abbreviate: append accumulated num as well as current char c[i].
 * In the end append remaining num.
 * Using StringBuilder can decrease 36.4% time.
 * This comes to the pattern I find powerful:
 * 
 * int len = sb.length(); // decision point
 * ... backtracking logic ...
 * sb.setLength(len);     // reset to decision point
 * 
 */
public class WordAbbreviationGenerate {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
		return res;
	}

	public void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
		int len = sb.length();  
		if(i == c.length) {
			if(num != 0) sb.append(num);
			res.add(sb.toString());
		} else {
			DFS(res, sb, c, i + 1, num + 1);               // abbr c[i]

			if(num != 0) sb.append(num);                   // not abbr c[i]
			DFS(res, sb.append(c[i]), c, i + 1, 0);        
		}
		sb.setLength(len); 
	}
}
