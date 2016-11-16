package leetcode.Graph;

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
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

	private static void clearRestOfLand(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;

		grid[i][j] = '0';
		clearRestOfLand(grid, i+1, j);
		clearRestOfLand(grid, i-1, j);
		clearRestOfLand(grid, i, j+1);
		clearRestOfLand(grid, i, j-1);
		return;
	}
	
	public static void main(String[] args){
		char[][] grid = {{'1','1','0','0'},
						 {'1','0','1','1'},
						 {'0','1','1','0'},
						 {'1','0','1','1'}};
		System.out.println(numIslands(grid));
	}
}
