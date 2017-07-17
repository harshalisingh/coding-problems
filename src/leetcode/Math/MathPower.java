package leetcode.Math;

/*
 * Write a program to output power(m,n)
 */
public class MathPower {
	//leetcode
	public double myPow(double x, int n) {
		double pow = 1L;
		if (x == 0) return 0;
		if(n == 0)
			return 1;
		if(n < 0){
			n = -n;
			x = 1/x;
		}
		if (x == Double.POSITIVE_INFINITY) {
			return 0;
		}
		if(n%2==0){
			pow = myPow(x, n / 2);
			return pow * pow;
		}
		else{
			pow = myPow(x,n/2);
			return pow * pow * x;
		}
	}


	public double power(long x, int n) {

		double pow = 1L;
		if(n==0)
			return 1;
		if (n == 1)
			return x;
		if(n%2==0){
			pow = power(x, n / 2);
			return pow * pow;
		}
		else{
			pow = power(x,n/2);
			return pow * pow * x;
		}
	}

}
