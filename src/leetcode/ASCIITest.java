package leetcode;

public class ASCIITest {
	public static void main(String [] args) throws Exception {
		String bar = "abc";
		int foo = bar.charAt(1) - '0';
		int foob = bar.charAt(1);
		System.err.println("foo = " + foo + "   foob = " + foob);
		
		int x = '0' - 'A';
		
		System.out.println('a' - '0');
		System.out.println(x);
	}
}
