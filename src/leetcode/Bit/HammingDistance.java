package leetcode.Bit;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {
	/*
	 * The problem is basically the same as counting the 1 bits in an integer, 
	 * and the useful trick to do that is : xor & (xor - 1) will eliminate the last 1 bit in a integer.
	 */
	public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
}
