package leetcode.DP;


public class LongestPalindromicSubstring {
	
	/*
	 * Key idea, every time we move to right, we only need to consider whether using this new character as tail 
	 * could produce new palindrome string of length (current length +1) or (current length +2)
	 */
	public String longestPalindrome(String s) {
        int curLen = 0;
        int start = -1;
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            if(isPalindrome(array, i - curLen - 1, i)) {
                start = i - curLen - 1;
                curLen += 2;
            } else if (isPalindrome(array, i - curLen, i)) {
                start = i - curLen;
                curLen += 1;
            }
        }
        return new String(array, start, curLen);
    }
    private boolean isPalindrome(char[] array, int start, int end) {
        if(start < 0) {
            return false;
        }
        while(start < end) {
            if(array[start++] != array[end--]) {
                return false;
            }
        }
        return true;
    }
	
	/*
	 * https://leetcode.com/problems/longest-palindromic-substring/#/description
	 * Time Complexity : O(n^2)
	 * Space Complexity: O(n^2)
	 */
	public String longestPalindromeDP(String s) {
		int n = s.length();
		String res = null;

		// dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
		boolean[][] dp = new boolean[n][n];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				System.out.println(i + "," + j);
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
	
	public static void main(String[] args){
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("abad"));
	}
}
