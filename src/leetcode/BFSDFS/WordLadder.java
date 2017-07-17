package leetcode.BFSDFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * https://leetcode.com/problems/word-ladder/#/description
 */
public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		// Use queue to help BFS
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);

		// Mark visited word
		Set<String> visited = new HashSet<String>();
		visited.add(start);

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String str = queue.poll();

				// Modify str's each character (so word distance is 1)
				for (int k = 0; k < str.length(); k++) {
					char[] chars = str.toCharArray();

					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;

						String word = new String(chars);

						// Found the end word
						if (word.equals(end)) return level + 1;

						// Put it to the queue
						if (dict.contains(word) && !visited.contains(word)) {
							queue.add(word);
							visited.add(word);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
}
