package leetcode.DP;

/*
 * Time Complexity of the above implementation is O(n^2)
 */
public class LongestPalindromicSubsequence {
	int longestPalindromeSubseqBruteForce(char[] s) {
		return longestPalindromeSubseq(0, s.length - 1, s); 
	}
	int longestPalindromeSubseq(int l, int r, char[] s) {
		if(l == r) return 1;
		if(l > r) return 0;  //happens after "aa" 
		return s[l]==s[r] ? 2 + longestPalindromeSubseq(l+1,r-1, s) : 
			Math.max(longestPalindromeSubseq(l+1,r, s),longestPalindromeSubseq(l,r-1, s)); 
	}

	//Bottom-Up
	public int lpsBottomUp(char[] str){
		int T[][] = new int[str.length][str.length];
		for(int i=0; i < str.length; i++){
			T[i][i] = 1;
		}
		for(int l = 2; l <= str.length; l++){
			for(int i = 0; i < str.length - l + 1; i++){
				int j = i + l - 1;
				if(l == 2 && str[i] == str[j]){
					T[i][j] = 2;
				}else if(str[i] == str[j]){
					T[i][j] = T[i + 1][j-1] + 2;
				}else{
					T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
				}
			}
		}
		return T[0][str.length-1];
	}

	//Top-Down
	public int lpsTopDown(char str[],int i,int j){
		int[][] DP = new int[str.length][str.length];
		for(int k=0; k < str.length; k++){
			DP[k][k] = -1;
		}

		if(i > j) return 0;
		if(i == j)return 1;
		if(DP[i][j] != 0)
			return DP[i][j];

		if(str[i] == str[j]){
			DP[i][j] = 2 + lpsTopDown(str,i+1,j-1);
		} else{
			DP[i][j] =  Math.max(lpsTopDown(str, i+1, j), lpsTopDown(str, i, j-1));
		}

		return DP[i][j];

	}
	
	public int LongestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // len 1
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        
        // len 2
        for (int i = 0, j = 1; j < n; i++, j++) dp[i][j] = s.charAt(i) == s.charAt(j)? 2 : 1;
        
        // len 3 and up
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = len - 1; j < n; i++, j++) {
                // better of without left or without right
                int max = Math.max(dp[i][j-1], dp[i+1][j]);
                if (s.charAt(i) == s.charAt(j))
                {
                    // now check 2 plus without left and without right
                    max = Math.max(max, 2 + dp[i+1][j-1]);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[0][n-1];
    }
	/*
	 * dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
	 * State transition:
	 * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
	 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
	 * Initialization: dp[i][i] = 1
	 */
	public int longestPalindromeSubseqDP(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
	
	//Top Down recursive method with memoization
	public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }
    
    private int helper(String s, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }

	public static void main(String args[]){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbdba";
		int r1 = lps.lpsTopDown(str.toCharArray(), 0, str.length() - 1);
		int r2 = lps.lpsBottomUp(str.toCharArray());
		System.out.print(r1 + " " + r2);
	}

}
