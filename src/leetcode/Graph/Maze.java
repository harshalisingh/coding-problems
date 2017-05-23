package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*The ball can go through empty spaces by rolling up, down, left or right, 
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Input 1: a maze represented by a 2D array, +(start), *(dest)
	0 0 1 0 +
	0 0 0 0 0
	0 0 0 1 0
	1 1 0 1 1
	0 0 0 0 *

	Input 2: start coordinate (rowStart, colStart) = (0, 4)
	Input 3: destination coordinate (rowDest, colDest) = (4, 4)
	Output: true
	Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 */
public class Maze {
	public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		int[] dx = new int[]{0, -1, 0, 1};
		int[] dy = new int[]{1, 0, -1, 0};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		visited[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] curPos = queue.poll();
			if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
				return true;
			}
			// try four direction until it hits the wall
			for (int direction = 0; direction < 4; direction++) {
				int nx = curPos[0], ny = curPos[1];
				while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
					nx += dx[direction];
					ny += dy[direction];
				}

				//back one step
				nx -= dx[direction];
				ny -= dy[direction];

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					System.out.println(nx + ", " + ny);
					queue.offer(new int[]{nx, ny});
				}
			}
		}
		return false;
	}


	int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, 1}, {0, -1} };

	public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, start, destination, visited);
	}

	private boolean dfs(int[][] maze, int[] p, int[] destination, boolean[][] visited) {
		if (visited[p[0]][p[1]]) {
			return false;
		}
		if (p[0] == destination[0] && p[1] == destination[1]) {
			return true;
		}
		visited[p[0]][p[1]] = true;
		for (int i = 0; i < dirs.length; i++) {
			int[] d = dirs[i];
			int row = p[0];
			int col = p[1];
			while (isValid(maze, row + d[0], col + d[1])) {
				row += d[0];
				col += d[1];
			}
			if (dfs(maze, new int[]{ row, col }, destination, visited)) {
				return true;
			}
		}
		return false;
	}

	private boolean isValid(int[][] maze, int row, int col) {
		return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1;
	}

	public static void main(String[] args){
		int[][] maze = new int[][]{
			{0,0,1,0,0},
			{0,0,0,0,0},
			{0,0,0,1,0},
			{1,1,0,1,1},
			{0,0,0,0,0}};
			int[] start = {0,4}; int[] dest = {4,4};
			Maze m = new Maze();
			m.hasPathBFS(maze, start, dest);

	}
}
