package leetcode.DP;

public class Fibonacci {
	public static void main(String[] args){
		System.out.println(fibTopDown(7));
		System.out.println(Fibonacci1D(7));
		System.out.println(FibonacciNoSpace(7));
		System.out.println('a' - '0');
	}
	
	//Top-Down
	public static int fibTopDown(int n) {
		int[] fib = new int[n+1];
		if(n <= 1)
			return n;
		
		if(fib[n] == 0){
			fib[n] = fibTopDown(n-1) + fibTopDown(n-2);
		}
		return fib[n];
		
	}
	
	
	public static int Fibonacci1D(int n) {
		int f[] = new int[n+1];
	    int i;
	      
	    /* 0th and 1st number of the series are 0 and 1*/
	    f[0] = 0;
	    f[1] = 1;
	     
	    for (i = 2; i <= n; i++)
	    {
	       /* Add the previous 2 numbers in the series
	         and store it */
	        f[i] = f[i-1] + f[i-2];
	    }
	      
	    return f[n];
    }
	
	public static int FibonacciNoSpace(int n) {
        if (n == 1) {
            return 0;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
