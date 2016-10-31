package leetcode.DP;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
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
	    return dp[s.length()];
	}
}
