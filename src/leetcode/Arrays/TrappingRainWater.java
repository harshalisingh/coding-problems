package leetcode.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * https://leetcode.com/problems/trapping-rain-water/#/description
 */
public class TrappingRainWater {
	public int trap(int[] heights) {

		if ( heights.length <= 2 ) { return 0; }

		int left = 0, right = heights.length-1, totalArea = 0;
		int leftMaxHeight = 0, rightMaxHeight = 0;

		while ( left <= right ) {
			leftMaxHeight = Math.max(leftMaxHeight, heights[left]);
			rightMaxHeight = Math.max(rightMaxHeight, heights[right]);
			if ( leftMaxHeight < rightMaxHeight ) {
				totalArea += leftMaxHeight - heights[left];
				left++;
			} else {
				totalArea += rightMaxHeight - heights[right];
				right--;
			} 
		}
		return totalArea;
	}
}
