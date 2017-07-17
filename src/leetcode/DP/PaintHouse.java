package leetcode.DP;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; 
 * costs[1][2] is the cost of painting house 1 with color green, and so on... 
 * Find the minimum cost to paint all houses.
 */
public class PaintHouse {
	/* The basic idea is when we have painted the first i houses, and want to paint the i+1 th house, 
	 * we have 3 choices: paint it either red, or green, or blue. If we choose to paint it red, we have the follow deduction:
	 * paintCurrentRed = min(paintPreviousGreen,paintPreviousBlue) + costs[i+1][0]
	 */
	public int minCostDP1(int[][] costs) {
		if(costs==null || costs.length==0)
			return 0;

		int lastR = costs[0][0];
		int lastG = costs[0][1];
		int lastB = costs[0][2];
		for(int i=1; i < costs.length; i++){
			int curR = Math.min(lastG,lastB) + costs[i][0];
			int curG = Math.min(lastR,lastB) + costs[i][1];
			int curB = Math.min(lastR,lastG) + costs[i][2];
			lastR = curR;
			lastG = curG;
			lastB = curB;
		}
		return Math.min(Math.min(lastR,lastG),lastB);
	}

	public int minCostDP2(int[][] costs) {
		if(costs==null||costs.length==0){
			return 0;
		}
		for(int i=1; i<costs.length; i++){
			costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
		}
		int n = costs.length-1;
		return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
	}

	/* Paint House II - k colors - Time: O(nk)
	 * Use min1 and min2 to track the indices of the 1st and 2nd smallest cost till previous house, 
	 * if the current color's index is same as min1, then we have to go with min2, otherwise we can safely go with min1.
	 */

	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

		int n = costs.length, k = costs[0].length;
		if(k == 1) return (n==1? costs[0][0] : -1);

		// prevMin is the 1st-smallest cost till previous house
		// prevSecMin is the 2nd-smallest cost till previous house
		int prevMin = 0, prevMinInd = -1, prevSecMin = 0; //always prevMin <= prevSecMin 
		for(int i = 0; i < costs.length; i++) {
			int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
			for(int j = 0; j < costs[0].length;  j++) {

				// If same color as j - 1, we can only extend from 2nd min of j - 1
				int cost = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);

				if(cost < min) {       // cost < m1 < m2		 
					secMin = min;
					min = cost;
					minInd = j;
				} else if(cost < secMin) {  // m1 < cost < m2
					secMin = cost;
				}
			}
			prevMin = min;
			prevMinInd = minInd;
			prevSecMin = secMin;
		}
		return prevMin;
	}
}
