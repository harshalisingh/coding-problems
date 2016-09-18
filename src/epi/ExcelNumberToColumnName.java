package epi;

public class ExcelNumberToColumnName {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String result = getExcelColumnName(4);
		System.out.print(result);
	}
	
	public static String getExcelColumnName(int x){
	    
	    StringBuilder s = new StringBuilder();
	    
	    do{
	        char c = (char)((x-1) % 26 + 'A');
	        s.append(c);
	        x = (x-1)/ 26;
	    } while(x != 0);
	    
	    s.reverse();
	    return s.toString();
	}

}
