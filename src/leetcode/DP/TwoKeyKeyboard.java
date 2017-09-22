package leetcode.DP;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class TwoKeyKeyboard {
	public static int minStepsDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // sub-problem dp[i] := minSteps(i)
            for (int j = 2; j <= i; j++) {
                // j := use j steps to create j copies
                if (i % j == 0) {
                    dp[i] = j + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
	
	/* Pure Loop
	 * We look for a divisor d so that we can make d copies of (n / d) to get n
	 * The process of making d copies takes d steps (1 step of Copy All and d - 1 steps of Paste)
	 * We keep reducing the problem to a smaller one in a loop.
	 */
	public static int minSteps(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }
	
	public static void main(String[] args){
		System.out.println(TwoKeyKeyboard.minSteps(8));
		System.out.println(TwoKeyKeyboard.minStepsDP(8));
	}
}
