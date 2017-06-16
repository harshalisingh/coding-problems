package leetcode.Bit;

public class CountSetBits {
	public static void main(String[] args){
		System.out.println(countSetBits(9));
		System.out.println(countSetBitsFast(9));
		System.out.println(parityFaster(223));
	}
	
	/* Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
	 * The run time depends on the number of bits in n. 
	 * Because n in this piece of code is a 32-bit integer, the time complexity is O(1). Space: O(1)
	 */
	public int hammingWeight(int n) {
	    int bits = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    return bits;
	}
	
	//O(n)   n = no. of bits
	public static short countSetBits(int x){
		short numBits = 0;
		while(x!=0){
			numBits += (x & 1);  //logical and to find out least significant bit is 1 or 0
			x >>>= 1;  //unsigned right shift
		} 
		return numBits;
	}
	
	//O(s)  s = no. of set bits
	public static short countSetBitsFast(int x){
		short numBits = 0;
		while(x != 0){
			x &= (x-1);   //flips the least significant 1-bit (lowest set bit) of x to 0
			numBits++;
		}
		return numBits;
	}
	
	//----------------------------------------------
	/*Parity 
	 * parity(1101) = 1,  parity(10000100) = 0
	 */
	
	//O(n)   n = no. of bits
		public static short parity(int x){
			short result = 0;
			while(x!=0){
				result ^= (x & 1);
				x >>>= 1;
			} return result;
		}
		
		//O(s)  s = no. of set bits
		public static short parityFast(int x){
			short result = 0;
			while(x != 0){
				x &= (x-1);
				result ^= 1;
			}
			return result;
		}
		
		public static short parity(long x){
			final int WORD_SIZE = 16;
			final int BIT_MASK = 0xFFFF;
			return (short)(
					parity((int) ((x >>> (3 * WORD_SIZE) & BIT_MASK)))
					^ parity((int) ((x >>> (2 * WORD_SIZE) & BIT_MASK)))
					^ parity((int) ((x >>> WORD_SIZE) & BIT_MASK))
					^ parity((int) (x & BIT_MASK))
					);
		}
		
		//O(log n)
		public static short parityFaster(long x){
			x ^= x >>> 32;
			x ^= x >>> 16;
			x ^= x >>> 8;
			x ^= x >>> 4;
			x ^= x >>> 2;
			x ^= x >>> 1;
			return (short) (x & 1);
			
		}
}
