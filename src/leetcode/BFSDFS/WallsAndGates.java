package leetcode.BFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class WallsAndGates {
	class DFS1 {
		public void wallsAndGates(int[][] rooms) {
			for(int i = 0; i < rooms.length; i++) {
				for(int j = 0; j < rooms[0].length; j++) {
					if(rooms[i][j] == 0) //find gate
						dfs(rooms, i, j, 0);
				}
			}
		}
		private void dfs(int[][] rooms, int i, int j, int d) {
			if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;   //cell already has a smaller distance (includes wall case as well ,i.e. -1)
			rooms[i][j] = d;
			dfs(rooms, i - 1, j, d + 1);
			dfs(rooms, i, j - 1, d + 1);
			dfs(rooms, i + 1, j, d + 1);
			dfs(rooms, i, j + 1, d + 1);
		}
	}

	class DFS2 {
		private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		public void wallsAndGates(int[][] rooms) {
			for(int i = 0; i < rooms.length; i++) {
				for(int j = 0; j < rooms[0].length; j++) {
					if(rooms[i][j] == 0)
						dfs(rooms, i, j, 0);           
				}
			}
		}
		private void dfs(int[][] rooms, int i, int j, int d) {
            if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
            rooms[i][j] = d;
			for(int[] dir : dirs) {
				int x = i + dir[0], y = j + dir[1];
				dfs(rooms, x, y, d + 1);
			}
		}
	}

	class BFS {
		private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		public void wallsAndGates(int[][] rooms) {
			if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

			Deque<int[]> queue = new ArrayDeque<>();
			for (int i = 0; i < rooms.length; i++){
				for (int j = 0; j < rooms[0].length; j++){
					if (rooms[i][j] == 0) {
						queue.offer(new int[] {i, j}); // Put gate in the queue
					}	            	
				}
			}
			while (!queue.isEmpty()) {
				int[] point = queue.poll();
				int i = point[0], j = point[1];
				for(int[] dir: dirs){
					int x = i + dir[0], y = j + dir[1];
					if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] <= rooms[i][j]) continue;	
					rooms[x][y] = rooms[i][j] + 1;
					queue.offer(new int[]{x,y});
				}
			}
		}
	}

}
