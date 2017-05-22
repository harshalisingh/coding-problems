package leetcode.Strings;

import leetcode.Design.Trie;

public class LongestCommonPrefix {

	public static void main(String[] args){
		String arr[] = {"geeksforgeeks", "geeks",
				"geek", "geezer"};
		int n = arr.length;
		//String ans = commonPrefixCharByChar (arr, n);
		//String ans = commonPrefixDivideAndConquer(arr, 0, n-1);
		
		LongestCommonPrefix l = new LongestCommonPrefix();
		String ans = l.lcpBinarySearch(arr);
		System.out.println(ans);
	}
	
	/* Horizontal scanning
	 * Time: O(S), S = sum of all characters in all strings
	 * Space: O(1)
	 */
	public String lcpWordByWord(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}

	/* Vertical Scanning
	 * Time: O(S) , where S is the sum of all characters in all strings. 
	 * In the worst case there will be n equal strings with length m and the algorithm performs S = m*n character comparisons. 
	 * Even though the worst case is still the same as Approach #1, 
	 * in the best case there are at most n*minLen comparisons where minLen is the length of the shortest string in the array.
	 * Space: O(1)
	 */
	public String lcpCharByChar(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}

	//=====================================================================

	// A Divide and Conquer based function to find the
	// longest common prefix. This is similar to the
	// merge sort technique
	
	/*
	 * In the worst case we have n equal strings with length m
	 * Time complexity : O(S), where S is the number of all characters in the array, S = m*n 
	 * Time complexity is T(n) = 2 T(n/2) + O(m). Therefore time complexity is O(S). 
	 * In the best case this algorithm performs O(minLen*n) comparisons
	 * Space complexity : O(m*log(n)). There are log(n) recursive calls, each store need m space to store the result
	 */
	public String lcpDivideAndConquer(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return lcpDivideAndConquer(strs, 0 , strs.length - 1);
	}

	private String lcpDivideAndConquer(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   lcpDivideAndConquer(strs, l , mid);
	        String lcpRight =  lcpDivideAndConquer(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}

	//=================================================================

	// A Function that returns the longest common prefix
	// from the array of strings
	/*
	 * In the worst case we have n equal strings with length m
	 * Time complexity : O(S*log(n))), where S is the sum of all characters in all strings.
	 * The algorithm makes log(n) iterations, for each of them there are S = m*n comparisons, which gives in total O(S*log(n)) time complexity.
	 * Space complexity : O(1). We only used constant extra space.
	 */
	public String lcpBinarySearch(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}
	
	//=================================================================
	/*
	 * Given a set of keys S = [S1, S2, .., Sn] find the longest common prefix among a string q and S. 
	 * This LCP query will be called frequently.
	 */
	
	public String longestCommonPrefix(String q, String[] strs) {
	    if (strs == null || strs.length == 0)
	         return "";  
	    if (strs.length == 1)
	         return strs[0];
	    Trie trie = new Trie();      
	    for (int i = 1; i < strs.length ; i++) {
	        trie.insert(strs[i]);
	    }
	    return trie.searchLongestPrefix(q);
	}

}
