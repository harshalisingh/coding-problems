package leetcode;

public class ReverseInteger {
	public static void main(String[] args){
		int x = -1000;
		System.out.print(reverse(x));
	}
	public static int reverse(int x){
		int result = 0;
		do {
			if(Math.abs(result) > 214748364){
				return 0;
			}
			result = result * 10 + x % 10;
			x /= 10;
		} while(x != 0);
		
		return result;
	}
}
