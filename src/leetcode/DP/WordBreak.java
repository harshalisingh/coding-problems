package leetcode.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. dictionary does not contain duplicate words.
 * For example, given s = "leetcode",   dict = ["leet", "code"].
 * https://leetcode.com/articles/word-break/
 */
public class WordBreak {
	public boolean wordBreakbruteForce(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
    
    /* Using Dynamic Programming
     * Time complexity : O(n^2). Two loops are their to fill dp array.
     * Space complexity : O(n). Length of dp array is n+1
     */
	public boolean wordBreak(String s, List<String> wordDict) {
	    if (s == null && wordDict == null)
	        return true;
	    if (s == null || wordDict == null)
	        return false;
	    //dp[i] represents if s.substring(0, i) is wordbreakable.
	    boolean[] dp = new boolean[s.length()+1];
	    dp[0] = true;
	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 0; j < i; j++) {
	            if (dp[j] && wordDict.contains(s.substring(j, i))) {
	                dp[i] = true;
	                break;
	            }
	        }
	    }
	    //System.out.println(Arrays.toString(dp));
	    //System.out.println(dp[s.length()]);
	    return dp[s.length()];
	}
	
	public static void main(String[] args){
		WordBreak wb = new WordBreak();
		String s = "leetcode";
		String[] wordDict = new String[]{"leet", "code"};
		wb.wordBreak(s, Arrays.asList(wordDict));
	}
}
