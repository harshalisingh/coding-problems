package leetcode.Bit;

public class NumberToBinary {
	public static void integerToBinary(int n){
		StringBuilder sb = new StringBuilder();
		while(n!=0){
			String bit = (n & 1) == 1? "1" : "0"; //logical and to find out least significant bit is 1 or 0
			sb.append(bit);
			n >>>= 1;  //unsigned right shift
		}
		System.out.println(sb.reverse().toString());
	}
	public static void main(String[] args){
		integerToBinary(32);
	}
}
