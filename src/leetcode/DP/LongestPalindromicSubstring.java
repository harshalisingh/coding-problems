package leetcode.DP;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/#/description
 * Time Complexity : O(n^2)
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		String res = null;

		boolean[][] dp = new boolean[n][n];
		// dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				
				//check if substring between (i,j) is palindrome
				// chars at i and j should match
				// if window is less than or equal to 3, just end chars should match
				// if window is > 3, substring (i+1, j-1) should be palindrome too
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}
}
