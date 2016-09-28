package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args){
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer ret = map.put("key", a);
		System.out.println("Value is ret : " + ret);
		
		Integer ret1 = map.put("key", b);
		System.out.println("Value is ret1 : " + ret1);
		System.out.println("Value of key : " + (map.get("key") == b));
		
		Integer ret2 = map.put("key", a);
		System.out.println("Value is ret2 : " + ret2);
		System.out.println("Value of key : " + (map.get("key") == b));
		
		System.out.println("Value is b : " + (map.get("key") == b));
	}
}
