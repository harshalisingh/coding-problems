package leetcode.DP;

/** Implement wildcard pattern matching with support for '?' and '*'.
   '?' Matches any single character.
   '*' Matches any sequence of characters (including the empty sequence).
    https://leetcode.com/problems/wildcard-matching/#/description
 */
public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println("regexMatch(\"aa\", \"a\") -> " + isMatch("aa", "a"));
		System.out.println("regexMatch(\"aa\", \"aa\") -> " + isMatch("aa", "aa"));
		System.out.println("regexMatch(\"aaa\", \"aa\") -> " + isMatch("aaa", "aa"));
		System.out.println("regexMatch(\"aa\", \"a*\") -> " + isMatch("aa", "a*"));
		System.out.println("regexMatch(\"aa\", \"*\") -> " + isMatch("aa", "*"));
		System.out.println("regexMatch(\"ab\", \"?*\") -> " + isMatch("ab", "?*"));
		System.out.println("regexMatch(\"aab\", \"c*a*b\") -> " + isMatch("aab", "c*a*b"));
		System.out.println("regexMatch(\"ccca\", \"c*a\") -> " + isMatch("ccca", "c*a"));
	}

	public static boolean isMatch(final String s, final String p) {
		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}
		boolean [][] dp = new boolean [s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 1]) {         
                    dp[0][j] = true;
            } 
        }
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= p.length(); ++j) {
				if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
					dp[i][j] = dp[i-1][j-1];
				}
				if (p.charAt(j-1) == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
