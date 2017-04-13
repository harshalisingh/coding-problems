package leetcode.DP;

/*
 * Base Cases: If any of the string is null then LCS will be 0.
 * Check if ith character in one string A is equal to jth character in string B
 * Case 1: both characters are same
 * LCS[i][j] = 1 + LCS[i-1][j-1] (add 1 to the result and remove the last character from both the strings 
 * and check the result for the smaller string.)
 * 
 * Case 2: both characters are not same.
 * LCS[i][j] = 0
 * At the end, traverse the matrix and find the maximum element in it, This will the length of Longest Common Substring.

 */
public class LongestCommonSubstring {
	public int longestCommonSubstring(char str1[], char str2[]){
		int m = str1.length;
		int n = str2.length;
        int T[][] = new int[m + 1][n + 1];
        
        int max = 0;
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(T[i][j] > max){
                        max = T[i][j];
                    }
                }
            }
        }
        return max;
    }
	
	public static void main(String args[]){
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		String str1 = "ABCDGHLQR";
		String str2 = "ABCPHR";

		int result = lcs.longestCommonSubstring(str1.toCharArray(), str2.toCharArray());
		System.out.print(result);
	}
}
