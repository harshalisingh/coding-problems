package leetcode.Bit;

public class BitwiseArithmetic {
	int Add(int x, int y) { 
		// Iterate till there is no carry 
		while (y != 0) { 
			int carry = x & y;  // carry now contains common set bits of x and y 
			x = x ^ y; 			// Sum of bits of x and y where at least one of the bits is not set 
			y = carry << 1;     // Carry is shifted by one so that adding it to x gives the required sum 
		} 
		return x; 
	}
	
	
}

