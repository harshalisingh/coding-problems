package leetcode.DP;

import java.util.Arrays;

public class CoinChangeMinimum {
	
	//Bottom-Up
	public int coinChangeMin(int[] coins, int amount) {
        int[] T = new int[amount + 1];
        Arrays.fill(T, Integer.MAX_VALUE);
        T[0] = 0;
        
        for(int i = 1; i <= amount; i++) 
    		for(int j = 0; j < coins.length; j++) 
    			if(coins[j] <= i) {
    				T[i] = Math.min(T[i], T[i-coins[j]] + 1);
    			}
    	return T[amount] == Integer.MAX_VALUE ? -1 : T[amount];
    }
}
