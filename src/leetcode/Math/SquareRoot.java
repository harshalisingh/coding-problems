package leetcode.Math;

//Implement int sqrt(int x).
public class SquareRoot {

	static // Returns floor of square root of x
	int floorSqrt(int x)
	{
		// Base cases
		if (x == 0 || x == 1)
			return x;

		// Staring from 1, try all numbers until
		// i*i is greater than or equal to x.
		int i = 1, result = 1;
		while (result < x)
		{
			if (result == x)
				return result;
			i++;
			result = i*i;
		}
		return i-1;
	}

	//O(logn)
	public static int mySqrt(int x) {
		// Base cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// If x is a perfect square
			if (mid * mid == x) {
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			} else if (mid * mid < x) {
				
				left = mid + 1;
				
			} else {

				// If mid*mid is greater than x
				right = mid - 1;
			}
		}
		return right;
	}

	// Driver Method
	public static void main(String args[])
	{
		int x = 11;
		System.out.println(floorSqrt(x));
		System.out.println(mySqrt(x));
	}
}
