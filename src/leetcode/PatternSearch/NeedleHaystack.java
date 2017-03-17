package leetcode.PatternSearch;

public class NeedleHaystack {
	//Pattern exists or not
	public static int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
	
	public boolean isRotated(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		String sAdd = s1 + s1;
		if(sAdd.contains(s2)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		System.out.println(strStr(text, pattern));
	}
	
}
