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
		
		
		
		String num = "123";
		String abc = "abc";
		String cap = "ABC";
		
		int i = num.charAt(1) - '0';
		int ia = abc.charAt(1) - 'a';
		char c = (char)(num.charAt(1) + 48);
		System.out.println("'2' - '0' = " + i + ", 'b' - 'a' = " + ia + ", '2' + 48 = " + c);
	}
}
