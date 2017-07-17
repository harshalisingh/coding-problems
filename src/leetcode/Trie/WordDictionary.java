package leetcode.Trie;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/#/description
 */
public class WordDictionary {
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length) {
			return node.isWord;
		}
		if (chs[k] != '.') {
			return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
					return true;
				}
			}
		}
		return false;
	}
}
