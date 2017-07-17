package leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

/* Generalized Abbreviation
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
	public List<String> generateAbbreviations1(String word){
        List<String> res = new ArrayList<String>();
        backtrack(res, word, 0, "", 0);
        return res;
    }
    private void backtrack(List<String> res, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            res.add(cur);
        }
        else{
            backtrack(res, word, pos + 1, cur, count + 1);
            backtrack(res, word, pos+1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
	
	public List<String> generateAbbreviations2(String word) {
		List<String> res = new ArrayList<>();
		DFS(res, word, 0, new StringBuilder(), 0);
		return res;
	}
	public void DFS(List<String> res, String word, int pos, StringBuilder cur, int count) {
		int len = cur.length();  
		if(pos == word.length()) {
			if(count > 0) cur.append(count);
			res.add(cur.toString());
		} else {
			DFS(res, word, pos + 1, cur, count + 1);               // abbr word.charAt(i)

			if(count > 0) cur.append(count);                   // not abbr word.charAt(i), so add previous count and word.charAt(i) character
			DFS(res, word, pos + 1, cur.append(word.charAt(pos)), 0);        
		}
		cur.setLength(len); 
	}
}
