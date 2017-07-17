package leetcode.contest;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) > 1) return false;
        for (int i = 0; i < Math.min(m, n); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;
            
            // s has the same length as t, so the only possibility is replacing one char in s and t
            if (m == n) return s.substring(i + 1).equals(t.substring(i + 1)); 
            
            // s is longer than t, so the only possibility is deleting one char from s
            if (m > n) return s.substring(i + 1).equals(t.substring(i));
            
         // t is longer than s, so the only possibility is deleting one char from t
            else return s.substring(i).equals(t.substring(i + 1));
        }
        
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(m - n) == 1; /* Only last char different. eg."abcd" "abc". Rule out equal case "abc" "abc" */
    }
}
