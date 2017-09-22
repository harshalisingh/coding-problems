package leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	public int wordMatch(String document, String[] keywords){
		String[] words = document.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for(String key : keywords) map.put(key, 0);
		int totalCount = 0;
		for(String word : words){
			if(map.containsKey(word) && map.get(word) == 0){
				totalCount++;
			}
			map.put(word, map.getOrDefault(word, 0) + 1);
			
		}
		return totalCount;
	}
	
	public int wordMatch2(String document, String[] keywords){
		String[] words = document.split(" ");
		int totalCount = 0;
		for(String keyword : keywords){
			for(String word: words){
				if(keyword.equals(word)){
					totalCount++;
					break;
				}
			}
			
		}
		return totalCount;
	}
	
	public int wordMatch3(String document, String[] keywords){
		String[] words = document.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for(String key : keywords) map.put(key, 1);
		int totalCount = 0;
		for(String word : words){
			if(map.containsKey(word)){
				totalCount++;
				map.put(word, map.get(word) - 1);
				if(map.get(word) == 0){
                    map.remove(word);
                    if(map.isEmpty()){
                        break;
                    }
                }
			}
		}
		return totalCount;
	}
	
	public static void main(String[] args){
		WordCount wc = new WordCount();
		String document = "the quick brown fox jumps quick over quick the brown lazy dog";
		String[] keywords = new String[]{"the", "quick", "brown"};
		System.out.println(wc.wordMatch(document, keywords));
		System.out.println(wc.wordMatch2(document, keywords));
		System.out.println(wc.wordMatch3(document, keywords));
		
	}
}
