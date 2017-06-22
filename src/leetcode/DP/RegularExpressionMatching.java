package leetcode.DP;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println("regexMatch(\"aa\", \"a\") -> " + regexMatch("aa", "a"));
		System.out.println("regexMatch(\"aa\", \"aa\") -> " + regexMatch("aa", "aa"));
		System.out.println("regexMatch(\"aaa\", \"aa\") -> " + regexMatch("aaa", "aa"));
		System.out.println("regexMatch(\"aa\", \"a*\") -> " + regexMatch("aa", "a*"));
		System.out.println("regexMatch(\"aa\", \".*\") -> " + regexMatch("aa", ".*"));
		System.out.println("regexMatch(\"ab\", \".*\") -> " + regexMatch("ab", ".*"));
		System.out.println("regexMatch(\"aab\", \"c*a*b\") -> " + regexMatch("aab", "c*a*b"));
		System.out.println("regexMatch(\"ccca\", \"c*a\") -> " + regexMatch("ccca", "c*a"));
	}

	public static boolean regexMatch(final String s, final String p){
		
		/*
		 * 1. If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
		 * 2. If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
		 * 3. If p.charAt(j) == '*': 
		 * here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
		 */
		if (s == null || p == null) {
	        return false;
	    }

		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = (dp[i][j-1]||dp[i][j-2]||dp[i-1][j]); 
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
	}
}