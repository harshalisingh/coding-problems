package leetcode.contest;

public class GuessNumberHigherOrLower {
	//https://leetcode.com/problems/guess-number-higher-or-lower/#/description
	public int guessNumber(int n) {
		int low = 1, high = n;
		while(low < high){
			int mid = low + (high - low) / 2;
			if(guess(mid) == 0){
				return mid;
			} else if(guess(mid) == 1){
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	private int guess(int mid) {
		return 0;
	}

	/* Min of Max Cost https://leetcode.com/problems/guess-number-higher-or-lower-ii/
	 * Big Idea: Given any n, we make a guess k. Then we break the interval [1,n] into [1,k - 1] and [k + 1,n]. 
	 * The min of worst case cost can be calculated recursively as
	 * cost[1,n] = k + max{cost[1,k - 1] , cost[k+1,n]}
	 * 
	 * Suppose the range is [start, end] the strategy here is to iterate through all number possible and select it as the starting point, 
	 * say for any k between start and end, 
	 * the worst cost for this is: k + max( DP(start, k-1), DP(k+1, end)), and the goal is minimize the cost, 
	 * so you need the minimum one among all those k between start and end
	 */
	public int getMoneyAmount(int n) {
		// all intervals are inclusive
		// uninitialized cells are assured to be zero
		// the zero column and row will be uninitialized
		// the illegal cells will also be uninitialized
		// add 1 to the length just to make the index the same as numbers used
		int[][] dp = new int[n + 1][n + 1]; // dp[i][j] means the min cost in the worst case for numbers (i...j)

		// iterate the lengths of the intervals since the calculations of longer intervals rely on shorter ones
		for (int len = 2; len <= n; len++) {
			
			// iterate all the intervals with length len, the start of which is i. Hence the interval will be [i, i + (l - 1)]
			for (int i = 1; i + (len - 1) <= n; i++) {
				int j = i + len - 1;
				int min = Integer.MAX_VALUE;
				
				// iterate all the first guesses k
				for (int k = i; k <= j; k++) {
					int costForThisGuess;
					// since if k is the last integer, k + 1 does not exist, we have to separate this case
					// cost for [i, i + (l - 1)]: k (first guess) + max{the cost of left part [i, k - 1], the cost of right part [k + 1, i + (l - 1)]}
					if (k == n) {
						costForThisGuess = dp[i][k - 1] + k;
					} else {
						costForThisGuess = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
					}
					min = Math.min(min, costForThisGuess); // keep track of the min cost among all first guesses
				}
				dp[i][j] = min;
			}
		}
		return dp[1][n];
	}
}
