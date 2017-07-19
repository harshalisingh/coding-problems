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
	
	public static int climbStairs1D(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
	
	public static int climbStairsNoSpace(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

	public static void main(String[] args){
		System.out.println(countWaysRecursive(3));
		System.out.println(countWaysDP(3));
		System.out.println(climbStairs1D(3));
		System.out.println(climbStairsNoSpace(3));
	}
}
