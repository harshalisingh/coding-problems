package leetcode.DP;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
	/* dp(i,j) represents the side length of the maximum square 
	 * whose bottom right corner is the cell with index (i,j) in the original matrix.
	 * dp(i,j) = Min( dp(i-1,j), dp(i-1, j-1), dp(i, j-1)) + 1;
	 * Time complexity : O(mn). Single pass. Space complexity : O(mn). Another matrix of same size is used for dp.
	 */
	public int maximalSquareDP(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
	
	/*
	 * Time complexity : O(mn). Single pass. Space complexity : O(n). Another array which stores elements in a row is used for dp.
	 */
	public int maximalSquareBetterDP(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = min(dp[j - 1], prev, dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
	private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
}
