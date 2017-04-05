package leetcode.Graph;

/*
 * You are given a matrix of dimensions m*n where each cell in the matrix can have values 0,1 or 2 which has the following meaning :
 * 0:empty cell
 * 1:cells have fresh oranges
 * 2:cells have rotten oranges
 * So we have to determine what is the minimum time required so that all the oranges will be rotten,
 * assuming it takes one second to rot the immediate neighbours. 
 * A rotten orange at index [i,j] can rot other fresh orange at indexes [i+1,j] ,[i,j+1] ,[i-1,j] ,[i,j-1]. 
 * If it is impossible to rot every orange then simply return -1
 */
public class TimeToRotOrange {
	int timeToRot = 0;
	public void problemTimeToRotOrange(int[][] farm) {
		timeToRotFarm(farm);
		for(int i = 0; i < farm.length; i++) {
			for(int j = 0; j < farm[0].length; j++) {
				if(farm[i][j] == 1) {
					timeToRot = -1;
					break;
				}
			}
		}
        System.out.println(timeToRot);
	}

	private void timeToRotFarm(int[][] farm) {
		boolean[][] visited = new boolean[farm.length][farm[0].length];
		for(int i = 0; i < farm.length; i++) {
			for(int j = 0; j < farm[0].length; j++) {
				if(farm[i][j] == 2)
					rotCrop(farm, i, j, visited);
			}
		}
	}

	private void rotCrop(int[][] farm, int i, int j, boolean[][] visited) {
		if(i < 0 || i == farm.length || j < 0 || j == farm[0].length || farm[i][j] == 0 || visited[i][j])
			return;
		if(farm[i][j] == 2) {
			visited[i][j] = true;
			// move north
			rotCrop(farm, i - 1, j, visited);
			// move east
			rotCrop(farm, i, j + 1, visited);
			// move south
			rotCrop(farm, i + 1, j, visited);
			// move west
			rotCrop(farm, i, j - 1, visited);
			return;
		} else if(farm[i][j] == 1){
			farm[i][j] = 2;
			timeToRot++;
			rotCrop(farm, i, j, visited);
		}
	}
	
	public static void main(String[] args){
		TimeToRotOrange rt = new TimeToRotOrange();
		int[][] farm = new int[][] {{1, 1, 1, 1, 0},
			{0, 1, 0, 1, 1},
			{2, 1, 1, 0, 2},
			{2, 1, 1, 0, 0}};
		//int[][] farm = new int[][] {{1, 0, 1, 1, 0},
		//			{0, 1, 0, 1, 1},
		//			{2, 1, 1, 0, 2},
		//			{2, 1, 1, 0, 0}};
		rt.problemTimeToRotOrange(farm);
	}
}
