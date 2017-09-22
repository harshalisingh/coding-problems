package leetcode.Math;

//Implement int sqrt(int x).
public class SquareRoot {

	//O(log x)
	public static int mySqrt(int x) {
		if (x == 0) return 0;
	    int left = 1, right = x;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (mid == x / mid) {
	            return mid;
	        } else if (mid < x / mid) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return right;
	}

	// Driver Method
	public static void main(String args[])
	{
		int x = 16;
		System.out.println(mySqrt(x));
	}
}
