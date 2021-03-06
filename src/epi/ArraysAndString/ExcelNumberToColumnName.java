package epi.ArraysAndString;

public class ExcelNumberToColumnName {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String result = getExcelColumnName(1);
		System.out.print(result);
	}
	
	public static String getExcelColumnName(int x){
	    
	    StringBuilder s = new StringBuilder();
	    
	    while(x != 0){
	        char c = (char)((x-1) % 26 + 'A');
	        s.append(c);
	        x = (x-1)/ 26;
	    } 
	    
	    return s.reverse().toString();
	}

}
