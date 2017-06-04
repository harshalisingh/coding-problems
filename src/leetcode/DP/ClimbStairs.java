package leetcode.DP;

import java.util.Arrays;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1, 2 or 3 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
	
	//Brute Force, time complexity: O(3^n)
	public static int countWaysRecursive(int n){
		if(n < 0) return 0;
		else if (n == 0) return 1;
		else return countWaysRecursive(n-1) + countWaysRecursive(n-2) + countWaysRecursive(n-3);
	}
	
	public static int countWaysDP(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		return countWays(n, map);
	}
	
	public static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}
	
	public static int climbStairs(int n) {
		if(n < 0) return 0;
		else if (n == 0) return 1;
		else if (n < 3) return n;
	    int[] memo = new int[n+1];
	    memo[0] = 1;
	    memo[1] = 1;
	    memo[2] = 2;
	    for(int i = 3; i <= n; i++) {
	    	memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
	    }
	    return memo[n-1] + memo[n-2] + memo[n-3];
	}

	public static void main(String[] args){
		System.out.println(countWaysRecursive(3));
		System.out.println(countWaysDP(3));
		System.out.println(climbStairs(3));
	}
}
