package leetcode.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    class TrieNode {
    	public TrieNode[] children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() {
        	children = new TrieNode[27];
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
    
    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }
    
    TrieNode root;
    String prefix;
    
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        
        for (int i = 0; i < sentences.length; i++) {
        	insert(sentences[i], times[i]);
		}
    }
    
    private void insert(String sentence, int count) {
        TrieNode cur = root;
        for (char c : sentence.toCharArray()) {
        	if(cur.children[_int(c)] == null){
        		cur.children[_int(c)] = new TrieNode();
            }
        	cur = cur.children[_int(c)];
            cur.counts.put(sentence, cur.counts.getOrDefault(sentence, 0) + count);
        }
        cur.isWord = true;
    }
    
    private int _int(char c) {
    	return c == ' ' ? 26 : c - 'a';
	}

	public List<String> input(char c) {
        if (c == '#') {
        	insert(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode cur = root;
		for (char ch : prefix.toCharArray()) {
			if(cur.children[_int(ch)] == null){
				return new ArrayList<String>();
			}
			cur = cur.children[_int(ch)];
		}
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s : cur.counts.keySet()) {
            pq.add(new Pair(s, cur.counts.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }
    
    public static void main(String[] args){
    	String[] sentences = new String[] {"i love you","island","iroman","i love leetcode"};
    	int[] times = new int[] {5,3,2,2};
    	AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
    	List<String> param_1 = obj.input('i');
    	for(String p : param_1){
    		System.out.println(p);
    	}
    }
    
}
