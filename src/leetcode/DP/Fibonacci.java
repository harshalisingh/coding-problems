package leetcode.DP;

public class Fibonacci {
	public static void main(String[] args){
		System.out.println(fibTopDown(7));
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
}
