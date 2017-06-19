package epi.ArraysAndString;

/*
 * https://leetcode.com/problems/excel-sheet-column-number/#/description
 */
public class ExcelColumnNameToNumber {

	public static void main (String[] args) throws java.lang.Exception
	{
		int result = getExcelColumnNumber("AA");
		System.out.print(result);
	}

	public static int getExcelColumnNumber(String s){
		int result = 0;

		for(int i=0; i < s.length();i++){

			int digit = s.charAt(i) - 'A' + 1;
			result = result*26 + digit;
		}
		return result;
	}

}
