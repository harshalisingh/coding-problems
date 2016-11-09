package leetcode.Strings;

public class AddIntegerStrings {
	public String addStrings(String num1, String num2) {
		if(num1 == null || num1.length() == 0)
			return num2;

		if(num2 == null || num2.length() == 0)
			return num1;

		StringBuilder sb = new StringBuilder();

		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int aNum, bNum;
		int carry = 0;

		while(i > -1 || j > -1 || carry == 1){
			aNum = (i > -1) ? num1.charAt(i) - '0' : 0;
			bNum = (j > -1) ? num2.charAt(j) - '0' : 0;
			sb.append((aNum + bNum + carry) % 10);
			carry = (aNum + bNum + carry) / 10;
			i--; j--;
		}

		return sb.reverse().toString();
	}

}
