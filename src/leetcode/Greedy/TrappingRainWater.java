package leetcode.Greedy;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * https://leetcode.com/problems/trapping-rain-water/#/description
 * Time Complexity: O(n)
 */
public class TrappingRainWater {
	public int trap(int[] heights) {
		int i = 0, j = heights.length - 1, maxWater = 0;
		
		while(i < j){
			int width = j - i;
			
			maxWater = Math.max(maxWater, width * Math.min(heights[i], heights[j]));
			
			if(heights[i] < heights[j]){
				++i;
			} else if(heights[i] > heights[j]){
				--j;
			} else { //heights[i] == heights[j]
				++i;
				--j;
			}
		}
		return maxWater;
	}
}
