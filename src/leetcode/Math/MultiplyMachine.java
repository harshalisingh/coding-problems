package leetcode.Math;

/*
 * You have a machine which can do only multiply by 2, divide by 2 and 
 * Addition of 2 numbers. Write a detailed algorithm to multiply any two 
 * numbers, in this kind of a machine.

 */
public class MultiplyMachine {
	public static void main(String[] args){
		System.out.print(multiplyWithLimitation(2,2));
	}
	
	static int multiplyWithLimitation(int a, int b)
	{
		if(b == 1)
			return a;

		if(b % 2 == 0)
			return multiplyWithLimitation(a * 2, b / 2);
		else
			return (a + multiplyWithLimitation(a * 2, b / 2));
	}
}
