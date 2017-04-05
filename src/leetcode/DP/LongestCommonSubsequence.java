package leetcode.DP;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * Time Complexity: O(mn)
 */
public class LongestCommonSubsequence {
	public int lcsDynamic(char str1[],char str2[]){  
		int m = str1.length;
		int n = str2.length;
		int T[][] = new int[m + 1][n + 1];
		int max = 0;
		for(int i = 1; i < T.length; i++){
			for(int j = 1; j < T[i].length; j++){
				if(str1[i-1] == str2[j-1]) {
					T[i][j] = T[i - 1][j - 1] + 1;
				}
				else
				{
					T[i][j] = Math.max(T[i][j-1],T[i-1][j]);
				}
				if(T[i][j] > max){
					max = T[i][j];
				}
			}
		}
		
		int index = T[m][n];		 
		char[] lcs = new char[index];
		int i = m, j = n;
		while (i > 0 && j > 0)
		{
			// If current character in str1 and str2 are same, then
			// current character is part of LCS
			if (str1[i-1] == str2[j-1])
			{
				lcs[index-1] = str1[i-1]; // Put current character in result
				i--; j--; index--;     	 // reduce values of i, j and index
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (T[i-1][j] > T[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(new String(lcs));
		
		return max;
	}

	public static void main(String args[]){
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";

		int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
		System.out.print(result);
	}
}
