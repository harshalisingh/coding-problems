package leetcode.Design;

/*
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 * A trie can check if a string is a valid prefix in O(K) time, where K is the length of the string.
 * Searching for a key in a balanced tree costs O(mlogn) time complexity.
 */
class TrieNode {

	// R links to node children
	private TrieNode[] links;

	private final int R = 26;

	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containsKey(char ch) {
		return links[ch -'a'] != null;
	}
	public TrieNode get(char ch) {
		return links[ch -'a'];
	}

	// number of children non null links
	private int size;    
	public void put(char ch, TrieNode node) {
		links[ch -'a'] = node;
	}
	public void setEnd() {
		isEnd = true;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public int getLinks() {
		return size;
	}
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
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!node.containsKey(currentChar)) {
				node.put(currentChar, new TrieNode());
			}
			node = node.get(currentChar);
		}
		node.setEnd();
	}

	/* search a prefix or whole key in trie and
	 * returns the node where search ends
	 * Time complexity : O(m) In each step of the algorithm we search for the next key character. 
	 * In the worst case the algorithm performs m operations.
	 * Space complexity : O(1)
	 */
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);
			if (node.containsKey(curChar)) {
				node = node.get(curChar);
			} else {
				return null;
			}
		}
		return node;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
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
	
	/* In the worst case query q has length m and it is equal to all n strings of the array.
	 * Time complexity : preprocessing O(S), where S is the number of all characters in the array, LCP query O(m)
	 * Trie build has O(S) time complexity. To find the common prefix of q in the Trie takes in the worst case O(m).
	 * Space complexity : O(S)
	 * We only used additional S extra space for the Trie.
	 */
	public String searchLongestPrefix(String word) {
		TrieNode node = root;
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);
			if (node.containsKey(curChar) && (node.getLinks() == 1) && (!node.isEnd())) {
				prefix.append(curChar);
				node = node.get(curChar);
			}
			else
				return prefix.toString();
		}
		return prefix.toString();
	}

}
