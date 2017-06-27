package leetcode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
