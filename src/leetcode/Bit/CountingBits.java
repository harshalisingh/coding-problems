package leetcode.Bit;

/**
 * https://leetcode.com/articles/counting-bits/
 */
public class CountingBits {
	public int[] countBitsPopCount(int num) {
		int[] ans = new int[num + 1];
		for (int i = 0; i <= num; ++i)
			ans[i] = popcount(i);
		return ans;
	}
	private int popcount(int x){
		short numBits = 0;
		while(x != 0){
			x &= (x-1);   //flips the least significant 1-bit (lowest set bit) of x to 0
			numBits++;
		}
		return numBits;
	}

	/* DP + Least Significant Bit
	 * P(x) = P(x/2) + (x mod 2)
	 * Time complexity : O(n). For each integer x we need constant operations which do not depend on the number of bits in x.
	 * Space complexity: O(n)
	 */
	public int[] countBitsLSB(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
		return ans;
	}

	/* DP + Last Set bit 
	 * P(x) = P(x & (x - 1)) + 1;
	 * Time: O(n), Space: O(n)
	 */
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			ans[i] = ans[i & (i - 1)] + 1;
		return ans;
	}
}
