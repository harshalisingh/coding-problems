package leetcode.Trie;

class TrieNode {
	public boolean isWord; 
	public TrieNode[] children = new TrieNode[26];
}

public class Trie {
	private TrieNode root;	    
	public Trie() {
		root = new TrieNode();
	}

	/* Inserts a word into the trie.
	 * Time complexity : O(m), where m is the key length.
	 * Space complexity : O(m)
	 */
	public void insert(String word) {
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(cur.children[c - 'a'] == null){
				cur.children[c - 'a'] = new TrieNode();
			}
			cur = cur.children[c - 'a'];
		}
		cur.isWord = true;

	}

	/* search a prefix or whole key in trie and
	 * returns the node where search ends
	 * Time complexity : O(m) In each step of the algorithm we search for the next key character. 
	 * In the worst case the algorithm performs m operations.
	 * Space complexity : O(1)
	 */
	private TrieNode searchPrefix(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.children[c - 'a'] == null)
				return null;
			else cur = cur.children[c - 'a'];
		}
		return cur;
	}

	/* Returns if the word is in the trie.*/
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isWord;
	}

	/* Returns if there is any word in the trie
	 * that starts with the given prefix.
	 * Time complexity : O(m)
	 * Space complexity : O(1)
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	/*  
    Returns if the word is in the trie
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                return false;
            else cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null)
                return false;
            else cur = cur.children[c - 'a'];
        }
        return true;
    }

	 */
}