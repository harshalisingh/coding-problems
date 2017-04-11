package leetcode.Math;

public class GCDAndLCM {
	public static int GCDArray(int[] input)
    {
        if(input.length == 1) return input[0];
        int res = input[0];
        for(int i = 1; i < input.length; i++)
        {
            res = gcd(res, input[i]);
        }
        return res;
    }
	
	public static int gcd(int a, int b) {
	    return (b == 0) ? a : gcd(b, a % b);
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a,b);
	}
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {9,6,12,24};
        System.out.println(GCDArray(input));
    }
}
