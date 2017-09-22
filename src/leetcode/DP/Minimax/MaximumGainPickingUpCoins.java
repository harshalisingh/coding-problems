package leetcode.DP.Minimax;

/** Pick-Up Coin Game (EPI)
 * Even numbers of coins are places in a line, two players take turn at choosing one coin each - only from the two ends of the coin list.
 * Compute the maximum total value gained by the starting player.
 * Strategy: Minimize the maximum revenue the opponent can gain
 */
public class MaximumGainPickingUpCoins {
	
	//Time Complexity: O(n^2)
	public int pickUpCoins(int[] coins) {
		return maxRevenueForRange(coins, 0, coins.length - 1, new int[coins.length][coins.length]);
	}

	private static int maxRevenueForRange(int[] coins, int i, int j, int[][] maxRevenueForRange) {
		if (i > j) {
			// No coins left.
			return 0;
		}

		if (maxRevenueForRange[i][j] == 0) {
			
			//player 2 is playing optimally, so she will minimize player 1's revenue
			int maxRevenuePlayer1 = coins[i]
					+ Math.min(maxRevenueForRange(coins, i + 2, j, maxRevenueForRange), //p1 selected i, p2 selects i+1, now p1 choice: (i+2,j)
							maxRevenueForRange(coins, i + 1, j - 1, maxRevenueForRange)); //p1 selected i, p2 selects j, now p1 choice: (i+1,j-1)

			int maxRevenuePlayer2 = coins[j]
					+ Math.min(maxRevenueForRange(coins, i + 1, j - 1, maxRevenueForRange),//p2 selected j, p1 selects i, now p2 choice: (i+1,j-1)
							maxRevenueForRange(coins, i, j - 2, maxRevenueForRange));//p2 selected j, p1 selects j-1, now p2 choice: (i,j-2)

			maxRevenueForRange[i][j] = Math.max(maxRevenuePlayer1, maxRevenuePlayer2);
		}
		return maxRevenueForRange[i][j];
	}
	
	public static void main(String[] args){
		MaximumGainPickingUpCoins obj = new MaximumGainPickingUpCoins();
		int[] coins = new int[]{10,25,5,1,10,5};
		System.out.println(obj.pickUpCoins(coins));
	}
}
