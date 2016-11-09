package leetcode.DP;

/*
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
	public int minCost(int[][] costs) {
		if(costs==null||costs.length==0)
			return 0;

		for(int i=1; i<costs.length; i++){
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}

		int m = costs.length-1;
		return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}
	
	//k colors
	public int minCostII(int[][] costs) {
	    if(costs == null || costs.length == 0) return 0;
		int m = costs.length, n = costs[0].length;
		int min1 = 0, min2 = 0, idMin1 = -1;
		
		for(int i = 0; i < m; i++) {
			int m1 = Integer.MAX_VALUE, m2 = m1, idm1 = -1;
		
			for(int j = 0; j < n; j++) {
				// If same color as j - 1, we can only extend from 2nd min of j - 1
				int cost = costs[i][j] + (j == idMin1 ? min2 : min1);

				// Update m1 m2 if cost is smaller than any of them
				if(cost < m1) {               
					m2 = m1; m1 = cost; idm1 = j;
				} else if(cost < m2) {        
					m2 = cost;
				}
			}
			min1 = m1; idMin1 = idm1; min2 = m2; 
		}
		return min1;   
	}
}
