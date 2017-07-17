package leetcode.BFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/number-of-islands/#/description
 */
public class NumberOfIslands {
	class DFS1 {
		public int numIslands(char[][] grid) {
			int count = 0;

			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						count++;
						clearRestOfLand(grid, i, j);
					}
				}
			}
			return count;
		}

		private void clearRestOfLand(char[][] grid, int i, int j) {
			if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
			grid[i][j] = '0';
			clearRestOfLand(grid, i+1, j);
			clearRestOfLand(grid, i-1, j);
			clearRestOfLand(grid, i, j+1);
			clearRestOfLand(grid, i, j-1);
		}
	}
	
	class DFS2 {
		private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		public int numIslands(char[][] grid) {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						count++;
						clearRestOfLand(grid, i, j);
					}
				}
			}
			return count;
		}

		private void clearRestOfLand(char[][] grid, int i, int j) {
			if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
			grid[i][j] = '0';
			for(int[] dir : dirs){
				int x = i + dir[0], y = j + dir[1];
				clearRestOfLand(grid, x, y);
			}
		}
	}
	
	class BFS {
		private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		public int numIslands(char[][] grid) {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						count++;
						clearRestOfLand(grid, i, j);
					}
				}
			}
			return count;
		}

		private void clearRestOfLand(char[][] grid, int i, int j) {
			Deque<int[]> queue = new ArrayDeque<>();	
			grid[i][j] = '0';
            queue.offer(new int[] {i,j});
			while (!queue.isEmpty()) {
				int[] point = queue.poll();
				i = point[0]; j = point[1];
                
				//clear the neighbours
				for(int[] dir: dirs){
					int x = i + dir[0], y = j + dir[1];
					if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') continue;
					grid[x][y] = '0';
                    queue.offer(new int[] {x,y});
				}
			}
		}
	}
	
	public static void main(String[] args){
		NumberOfIslands nm = new NumberOfIslands();
		char[][] grid = {{'1','1','0','0'},
						 {'1','0','1','1'},
						 {'0','1','1','0'},
						 {'1','0','1','1'}};
		System.out.println(nm.new DFS1().numIslands(grid));
	}
}
