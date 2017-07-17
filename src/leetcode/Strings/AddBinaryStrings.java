package leetcode.Strings;

public class AddBinaryStrings {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		String Bs = "100001";
		String Bt = "101";
		
		String result = addBinaryStrings(Bs, Bt);
		
		System.out.println(result);
		
		
	}
	
	public static String addBinaryStrings(String a, String b) {
		if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        StringBuilder stb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? a.charAt(i--) - '0' : 0;
            bByte = (j > -1) ? b.charAt(j--) - '0' : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
