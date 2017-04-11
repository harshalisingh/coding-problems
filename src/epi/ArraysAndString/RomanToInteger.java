package epi.ArraysAndString;

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(){
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};

		int sum = map.get(s.charAt(s.length() - 1));
		for(int i = s.length() - 2; i >= 0; --i){
			if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
				sum -= map.get(s.charAt(i));
			} else {
				sum += map.get(s.charAt(i));
			}
		}
		return sum;
	}
}
