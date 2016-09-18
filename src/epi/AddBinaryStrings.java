package epi;

public class AddBinaryStrings {
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		String Bs = "100001";
		String Bt = "101";
		
		String result = addBinaryStrings(Bs, Bt);
		
		System.out.println(result);
		
		
	}
	
	public static String addBinaryStrings(String Bs, String Bt){
	    
	    if(Bs.length() < Bt.length()){
	        Bs = String.format("%0" + Math.abs(Bs.length() - Bt.length()) + "d%s", 0, Bs);
	    } else if(Bt.length() < Bs.length()) {
	        Bt = String.format("%0" + Math.abs(Bs.length() - Bt.length()) + "d%s", 0, Bt);
	    }
	    
	    int n = Bs.length() - 1;
        char[] res = new char[Bs.length()];
        res[n] = (char)(Character.getNumericValue(Bs.charAt(n)) + Character.getNumericValue(Bt.charAt(n)));

        int carry = 0;
        for(int i = n; i >= 0 ; --i){
            
            int s = Character.getNumericValue(Bs.charAt(i));
            int t = Character.getNumericValue(Bt.charAt(i));
            
            res[i] = Character.forDigit(s + t + carry, 10);
            
            if(res[i] == '2'){
                res[i] = '0';
                carry = 1;
            } else {
                carry = 0;
            }
            
        }
        
        if(res[0] == '2'){
            res[0] = '0';
            char[] newCharArr = new char[res.length + 1];
            System.arraycopy(res, 0, newCharArr, 1, res.length);
            newCharArr[0] = '1';
            
            return String.valueOf(newCharArr);
        } else {
        	return String.valueOf(res);
        }
        
	}
}
