package epi.Honors;

/**
 * The greatest common divisor of positive integers x and y is the largest integer d such that x % d = 0 and y % d = 0 
 * In every two calls, we reduce the combined bit length of the two numbers by at least one, meaning time complexity is proportional
 * to the sum of number of bits in x and y, i.e. O(logx + logy).
 */
public class GreastestGCD {
	public static int GCD(int x, int y){
		if(x == y){
			return x;
		} else if((x & 1) == 0 && (y & 1) == 0){ //x is even, y is even
			return GCD(x >>> 1, y >>> 1) << 1;
		} else if ((x & 1) != 0 && (y & 1) == 0){ //x is odd, y is even
			return GCD(x, y >>> 1);
		} else if ((x & 1) == 0 && (y & 1) != 0){ //x is even, y is odd
			return GCD(x >>> 1, y);
		} else if(x > y){ //Both x and y are odd, x > y
			return GCD(x - y, y);
		}
		return GCD(x, y - x); //Both x and y are odd, x <= y
	}
	
	public static void main(String[] args){
		System.out.println(GCD(24, 300));
	}
}
