package leetcode.DP;

import java.util.Arrays;

/** Minimum Coin Change
 * Time complexity : O(S*n). On each step the algorithm finds the next F(i) in n iterations, where 1 <= i <= S. 
 * Therefore in total the iterations are S*n
 * Space complexity : O(S). We use extra space for the memoization table.
 */
public class CoinChangeMinimum {
	//Minimum number of coins that you need to make up that amount
	public int totalCoinsMinimum(int amount, int[] coins){
		int max = amount + 1;
		int dp[] = new int[amount+1];
		Arrays.fill(dp, max);
		dp[0] = 0;  // 0 coins are required to make the change for 0
		for(int i=0; i < coins.length; i++){
			for(int j=1; j <= amount ; j++){
				if(j >= coins[i]){
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public static void main(String[] args){
		CoinChangeMinimum cc = new CoinChangeMinimum();
		int amount = 5;
		int[] coins = {1,2,3};
		System.out.println(cc.totalCoinsMinimum(amount, coins));
	}
}
