package leetcode.DP;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class BuySellStockI {
	public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
        
    }
	
	/*
	 * If the interviewer gives array of difference of prices
	 * Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}
	 * calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array,
	 * and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
	 */
	public int maxProfitVariation(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
