package leetcode.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/*
 * https://leetcode.com/problems/alien-dictionary/#/description
 * First, build a degree map for each character in all the words:
	w:0
	r:0
	t:0
	f:0
	e:0
Then build the hashmap by comparing the adjacent words, the first character that is different between two adjacent words reflect the lexicographical order. For example:

 "wrt",
 "wrf",
    first different character is 3rd letter, so t comes before f

 "wrf",
 "er",
    first different character is 1rd letter, so w comes before e
The characters in set come after the key. x->y means letter x comes before letter y. x -> set: y,z,t,w means x comes before all the letters in the set. The final HashMap "map" looks like.

t -> set: f    
w -> set: e
r -> set: t
e -> set: r
and final HashMap "degree" looks like, the number means "how many letters come before the key":
w:0
r:1
t:1
f:1
e:1
Then use Karn's aglorithm to do topological sort. This is essentially BFS.
https://en.wikipedia.org/wiki/Topological_sorting

Space: 26+26^2+26, O(1) Time: n*k + (n-1)*k + 26*26, O(n*k)
 */
public class AlienDictionary {
	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
		Map<Character, Integer> degree=new HashMap<Character, Integer>();
		String result="";
		if(words==null || words.length==0) return result;
		for(String s: words){
			for(char c: s.toCharArray()){
				degree.put(c,0);
			}
		}

		for(int i=0; i<words.length-1; i++){
			String cur=words[i];
			String next=words[i+1];
			//check for cases like, ["wrtkj","wrt"]; it's invalid, because this input is not in sorted lexicographical order
	        if( cur.length() > next.length() && cur.startsWith(next) )
	            return "";
			int length=Math.min(cur.length(), next.length());
			for(int j=0; j < length; j++){
				char c1=cur.charAt(j);
				char c2=next.charAt(j);
				if(c1!=c2){
					Set<Character> set=new HashSet<Character>();
					if(map.containsKey(c1)) set=map.get(c1);
					if(!set.contains(c2)){
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2)+1);
					}
					break;
				}
			}
		}

		//Display the final Map
	/*	for(Map.Entry<Character, Set<Character>> entrySet : map.entrySet()){
			char key = entrySet.getKey();
			System.out.print(key);
			for(char c : entrySet.getValue()){
				System.out.println("->" + c + ",");
			}
		}
		*/

		Queue<Character> q=new LinkedList<Character>();
		for(char c: degree.keySet()){
			if(degree.get(c)==0) q.add(c);
		}
		while(!q.isEmpty()){
			char c=q.remove();
			result+=c;
			if(map.containsKey(c)){
				for(char c2: map.get(c)){
					degree.put(c2,degree.get(c2)-1);
					if(degree.get(c2)==0) q.add(c2);
				}
			}
		}
		if(result.length()!=degree.size()) return "";
		return result;
	}

	public static void main(String[] args){
		String[] words = {
				"wrt",
				"wrtj",
				"wrf",
				"er",
				"ett",
				"rftt"
		};
		System.out.println(alienOrder(words));
	}
}
