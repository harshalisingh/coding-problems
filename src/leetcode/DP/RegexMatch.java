package leetcode.DP;

public class RegexMatch {
	public boolean isMatch(String s, String p) {
	    /*
	    'match' below including .
	    dp[i][j] -> string s of length i matches with pattern p of length j
	    dp(i,j) means s where s.len=i matches p where p.len=j
	    dp(i,j) =
	        if (p_j-1 != * ) dp(i-1, j-1) and s_i-1 matches p_j-1
	        if (p_j-1 == * )
	            * matches zero times: dp(i,j-2)
	            or * matches at least one time: dp(i-1,j) and s_i-1 matches p_j-2
	     */

	    if (!p.isEmpty() && p.charAt(0) == '*') {
	        return false;   // invalid p
	    }

	    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

	    // initialize dp(0,0)
	    dp[0][0] = true;

	    // dp(k,0) and dp(0,2k-1) where k>=1 are false by default

	    // initialize dp(0,2k) where p_2k-1 = * for any k>=1
	    for (int j = 1; j < p.length(); j+=2) {
	        if (p.charAt(j) == '*') {
	        	dp[0][j+1] = dp[0][j-1];
	        }
	    }

	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 1; j <= p.length(); j++) {
	            if (p.charAt(j - 1) != '*') {
	            	dp[i][j] = dp[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
	            } else {
	            	dp[i][j] = dp[i][j - 2] //matches zero times
	            			|| dp[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2)); //matches 1 time
	            }
	        }
	    }

	    return dp [s.length()][p.length()];
	}

	// no * in p
	private boolean isCharMatch(char s, char p) {
	    return p == '.' || s == p;
	}
}
