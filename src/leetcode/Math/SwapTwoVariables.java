package leetcode.Math;

public class SwapTwoVariables {
	public static void main(String[] args){
		swapTemp();
		swapArithmetic();
		swapXOR();
	}
	public static void swapTemp(){
		int a = 10, b = 20;
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a: " + a + " b: " + b);
	}
	
	public static void swapArithmetic(){
		int a = 10, b = 20;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a: " + a + " b: " + b);
	}
	
	public static void swapXOR(){
		int a = 10, b = 20;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a: " + a + " b: " + b);
	}
}
