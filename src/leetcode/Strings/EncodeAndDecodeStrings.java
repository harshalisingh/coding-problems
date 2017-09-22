package leetcode.Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/tabs/description
 */
public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }
    
 // Decodes a single string to a list of strings.
    public List<String> decode(String s){
    	List<String> result = new ArrayList<>();
    	if(s == null || s.isEmpty())  return result;
    	int i = 0, len = s.length(), size = 0;
    	while(i < len){
    		size = 0;
    		while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
    			size = size * 10 + s.charAt(i) - '0';
    			i++;
    		}
    		int slashIdx = i;
    		result.add(s.substring(slashIdx + 1, slashIdx + size + 1));
    		i = slashIdx + size + 1;
    	}
    	return result;
    }
    
    /*
     public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }
     */
    
    public static void main(String[] args){
    	EncodeAndDecodeStrings caller = new EncodeAndDecodeStrings();
    	String[] array = {"this is a blue sky", "///", "/hello world"};
    	String encoded = caller.encode(Arrays.asList(array));
    	System.out.println(encoded);
    	
    	for(String s : caller.decode(encoded)){
    		System.out.println(s);
    	}
    }
}
