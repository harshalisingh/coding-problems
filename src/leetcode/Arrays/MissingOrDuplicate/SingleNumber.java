package leetcode.Arrays.MissingOrDuplicate;

public class SingleNumber {
	
	/* Given an array of integers, every element appears twice except for one. Find that single one.
	 * Bitwise XOR
	 * 0 ^ N = N,   N ^ N = 0
	 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
	 * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
	 * = 0 ^ 0 ^ ..........^ 0 ^ N
	 * = N
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int i : nums) {
			result ^= i;
		}
		return result;
	}
	
	
	
}
