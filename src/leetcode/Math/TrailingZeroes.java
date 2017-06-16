package leetcode.Math;

/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * https://discuss.leetcode.com/topic/6513/simple-c-c-solution-with-detailed-explaination/2
 * Time: O(Log5 N)
 * 
 * To count the number of zeros, we only need to count the pairs of 5-multiples and 2-multiples.
 */
public class TrailingZeroes {
	public int trailingZeroes(int n) {
		int cnt = 0;
		while(n > 0){
			cnt += n/5;
			n/=5;
		}
		return cnt;
	}
}
