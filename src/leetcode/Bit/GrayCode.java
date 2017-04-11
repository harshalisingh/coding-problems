package leetcode.Bit;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	/*
	 * Given two hexadecimal numbers find if they can be consecutive in gray code.
	 */
	public static boolean isConsecutive(byte a, byte b)
    {
        byte c = (byte)(a ^ b);
        int count = 0;
        while(c != 0)
        {
            c &= (c - 1);
            count++;
        }
        return count == 1;
    }
	
	/*
	 * https://leetcode.com/problems/gray-code/#/description
	 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
	 * For example, given n = 2, return [0,1,3,2].
	 */
	public List<Integer> grayCode(int n) {
	    List<Integer> rs=new ArrayList<Integer>();
	    rs.add(0);
	    for(int i=0;i<n;i++){
	        int size=rs.size();
	        for(int k=size-1;k>=0;k--)
	            rs.add(rs.get(k) | 1<<i);
	    }
	    return rs;
	}
}
