package leetcode.DP;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
	    int[][] grid = new int[m][n];
	    for(int i = 0; i<m; i++){
	        for(int j = 0; j<n; j++){
	            if(i==0||j==0)
	                grid[i][j] = 1;
	            else
	                grid[i][j] = grid[i][j-1] + grid[i-1][j];
	        }
	    }
	    return grid[m-1][n-1];
	}
	
	/* Now consider if some obstacles are added to the grids. How many unique paths would there be?
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    int m = obstacleGrid.length, n = obstacleGrid[0].length;
	    int[][] dp = new int[m + 1][n + 1];
	    dp[0][1] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (obstacleGrid[i - 1][j - 1] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m][n];
	}
	
	/* Array dp stores the number of paths which passing this point. 
	 * The whole algorithm is to sum up the paths from left grid and up grid. 
	 * 'if (row[j] == 1) dp[j] = 0; means if there is an obstacle at this point.
	 *  All the paths passing this point will no longer valid. 
	 *  In other words, the grid right of the obstacle can be reached only by the grid which lies up to it.
	 */
	public int uniquePathsWithObstaclesSpaceEfficient(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}
}
