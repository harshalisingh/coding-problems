package leetcode.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.Trie.Trie;

public class WordSearchII {
	Set<String> res = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}
		return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, boolean[][] visited, String str, int row, int column, Trie trie) {
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return;
		if (visited[row][column]) return;

		str += board[row][column];
		if (!trie.startsWith(str)) return;

		if (trie.search(str)) {
			res.add(str);
		}

		visited[row][column] = true;
		dfs(board, visited, str, row - 1, column, trie);
		dfs(board, visited, str, row + 1, column, trie);
		dfs(board, visited, str, row, column - 1, trie);
		dfs(board, visited, str, row, column + 1, trie);
		visited[row][column] = false;
	}
}
