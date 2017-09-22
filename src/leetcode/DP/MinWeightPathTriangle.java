package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Time spent per element is O(1) and there are 1+2+3...+n = n(n+1)/2 elements. So Time Complexity: O(n^2)
	Space: O(n)
 */
public class MinWeightPathTriangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        List<Integer> result = new ArrayList<Integer>(triangle.get(level-1));
        for(int i = level - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                result.set(j,Math.min(result.get(j),result.get(j+1)) //taking min of the two lower children in next row
                		+ triangle.get(i).get(j)); //plus it's own value
        return result.get(0);
    
    }
	
	public static void main(String[] args){
		MinWeightPathTriangle obj = new MinWeightPathTriangle();
		
	}
}
