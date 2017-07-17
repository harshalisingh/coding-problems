package leetcode.Math;

public class ReverseInteger {
	public static void main(String[] args){
		int x = -1000;
		System.out.println(reverse(Integer.MAX_VALUE));
		
		
		//System.out.println(Integer.MAX_VALUE);
	}
	public static int reverse(int x){
		int result = 0;
		do {
			if(Math.abs(result) > Integer.MAX_VALUE / 10){
				return 0;	
			}
			result = result * 10 + x % 10;
			x /= 10;
		} while(x != 0);
		
		return result;
	}
	
	public int reverseInteger(int x) {
        long result = 0;
        while( x != 0){
        	result = result * 10 + x % 10;
            x = x/10;
            if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return (int) result;
    }
}
