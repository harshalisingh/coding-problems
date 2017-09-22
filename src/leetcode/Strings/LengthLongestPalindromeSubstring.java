package leetcode.Strings;

public class LengthLongestPalindromeSubstring {

	//Time Complexity: O(n^3), Space: O(1)
	public int lengthLongestPalindromeSubstringBruteForce(String s){
		if(s == null || s.isEmpty()) return 0;	
		if(s.length() < 2) return 1;
		int maxlen = Integer.MIN_VALUE;

		for(int i = 0; i < s.length(); i++){
			for(int j = i; j < s.length(); j++){
				if(isPalindrome(s, i, j)){
					maxlen = Math.max(maxlen, j - i + 1);
				}
			}
		}
		return maxlen;		
	}

	private boolean isPalindrome(String s, int start, int end) {
		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	/*
	 * https://leetcode.com/problems/longest-palindromic-substring/#/description
	 * Time Complexity : O(n^2), Space Complexity: O(n^2)
	 */
	public String longestPalindromeDP(String s) {
		String res = null;

		// dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxLen = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				//System.out.println(s.substring(i, j));
				//check if substring between (i,j) is palindrome
				// chars at i and j should match
				// if window is less than or equal to 3, just end chars should match
				// if window is > 3, substring (i+1, j-1) should be palindrome too
				dp[i][j] = (s.charAt(i) == s.charAt(j) && j - i < 3) || dp[i + 1][j - 1];

				if (dp[i][j] && (res == null || j - i + 1 > maxLen)) {
					res = s.substring(i, j + 1);
					maxLen = res.length();
				}
			}
		}
		System.out.println(maxLen);
		return res;
	}
	
	/* Time complexity: O(n^2), Space: O(1) 
	 */
	public int longestPalindromeDPOptimized(String s) {
		int maxLength = 1;  // The result (length of LPS)	 
		int start = 0;
		int len = s.length();
		int low, high;

		// One by one consider every character as center point of 
		// even and length palindromes
		for (int i = 1; i < len; ++i) {
			// Find the longest even length palindrome with center points as i-1 and i.  
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			// Find the longest odd length palindrome with center point as i
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}
		return maxLength;
	}

	public static void main(String[] args){
		LengthLongestPalindromeSubstring o = new LengthLongestPalindromeSubstring();
		System.out.println(o.lengthLongestPalindromeSubstringBruteForce("abbcbbadgh"));
		System.out.println(o.longestPalindromeDP("abbcbbadgh"));
		System.out.println(o.longestPalindromeDPOptimized("abbcbbadgh"));
	}


}
