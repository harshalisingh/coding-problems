package leetcode.Greedy;

import java.util.Arrays;

/** Assign Cookies
 * Each child i has a greed factor g(i), which is the minimum size of a cookie that the child will be content with; 
 * and each cookie j has a size s(j). If s(j) >= g(i), we can assign the cookie j to the child i, and the child i will be content. 
 * Your goal is to maximize the number of your content children and output the maximum number.
 * https://leetcode.com/problems/assign-cookies/description/
 * Note: You may assume the greed factor is always positive. 
		 You cannot assign more than one cookie to one child.
 */
public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0;
        int j = 0;
        
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) { //if greed is less than or equal to size of cookie
                i++; //move to next child
                j++; //move to next cookie
            } else {
                j++; //move to next larger size cookie
            }
        }        
        return i; //number of children content
    }
}
