package leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/*
 * Given a String find the first non repeating char in a single pass of the string. 
 * Assume a big character set like utf-8 (eliminate use of char[256]) 
 * Avoid any subloop to have a very optimal solution
 */

public class FirstNonRepeatingCharacter {
	public static void main(String[] args){
		findFirstNonRepeating();
	}
	
	public static void findFirstNonRepeating() {

		String s = "abaadde";

		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (hm.get(c) != null) {
				Integer occ = hm.get(c);
				hm.put(c, ++occ);
				//O(1) operation
				lhs.remove(c);
			} else {
				//O(1) operation
				hm.put(c, 1);
				lhs.add(c);
			}
		}
	        //O(1) operation		
		Iterator<Character> itr = lhs.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			break;
		}
	}
	
	//Using Boolean array and ArrayList
	public Character firstNonRepeatingChar(String str) {
        if(str.length() == 0) {
            return null;
        }
        ArrayList<Character> temp = new ArrayList<Character>();
        boolean[] charmap = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (!charmap[val]) {
                temp.add(str.charAt(i));
                charmap[val] = true;
            } else {
                if (temp.size() != 0) {
                    temp.remove((Character) str.charAt(i));
                }
            }
        }

        if (temp.size() == 0) {
            return null;
        }
        return temp.get(0);
    }
}
