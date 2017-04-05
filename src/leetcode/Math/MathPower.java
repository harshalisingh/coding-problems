package leetcode.Math;

public class MathPower {
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
