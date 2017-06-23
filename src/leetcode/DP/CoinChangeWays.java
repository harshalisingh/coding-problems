package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a total and coins of certain denominations find number of ways total
 * can be formed from coins assuming infinity supply of coins
 */
public class CoinChangeWays {
	//Time Com­plex­ity : O(2^n)
	public int totalWaysRecursive(int totalAmount, int[] coins, int index) {
		if (totalAmount < 0) {
			return 0;
		}
		if (totalAmount == 0) {
			return 1;
		}
		// means coins over and n>0 so no solution
		if (index == coins.length && totalAmount > 0) {
			return 0;
		}
		return totalWaysRecursive(totalAmount - coins[index], coins, index) //include coin[index] in solution
				+ totalWaysRecursive(totalAmount, coins, index + 1);        //do not include coin[index] in solution
	}

	//Space efficient DP Time Complexity: O(mn)
	public int totalWaysDPSpace(int total, int[] coins){
		int dp[] = new int[total+1];
		dp[0] = 1;     //if we take 2 as a coin and subtract it from the sum it becomes 0 and the 
		               //number of ways we can get zero from denomination of 2 is only one
		for(int i=0; i < coins.length; i++){
			for(int j=1; j <= total ; j++){
				if(j >= coins[i]){
					dp[j] = dp[j - coins[i]] + 1;
				}
			}
		}
		return dp[total];
	}

	//Minimum number of coins that you need to make up that amount
	public int totalCoinsMinimum(int total, int[] coins){
		int dp[] = new int[total+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;  // 0 coins are required to make the change for 0
		for(int i=0; i < coins.length; i++){
			for(int j=1; j <= total ; j++){
				if(j >= coins[i]){
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[total] == Integer.MAX_VALUE ? -1 : dp[total];
	}

	/*
	 * This method actually prints all the combination. It takes exponential time.
	 */
	public void printCoinChangingSolution(int total,int[] coins){
		List<Integer> result = new ArrayList<>();
		printActualSolution(result, total, coins, 0);
	}

	private void printActualSolution(List<Integer> result,int total,int[] coins,int pos){
		if(total == 0){
			for(int r : result){
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for(int i=pos; i < coins.length; i++){
			if(total >= coins[i]){
				result.add(coins[i]);
				printActualSolution(result,total-coins[i],coins,i);
				result.remove(result.size()-1);
			}
		}
	}   

	public static void main(String[] args){
		CoinChangeWays cc = new CoinChangeWays();
		int total = 5;
		int[] coins = {1,2,3};
		//System.out.println(cc.totalWaysRecursive(total, coins, 0));
		//System.out.println(cc.totalWaysDP(total, coins));
		System.out.println(cc.totalWaysDPSpace(total, coins));
		System.out.println(cc.totalCoinsMinimum(total, coins));
		//cc.printCoinChangingSolution(total, coins);
	}
}
