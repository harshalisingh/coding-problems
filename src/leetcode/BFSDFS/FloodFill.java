package leetcode.BFSDFS;

public class FloodFill {
	// It mainly finds the previous color on (x, y) and
	// calls floodFillUtil()
	static void floodFill(int screen[][], int x, int y, int newC)
	{
		int prevC = screen[x][y];
		floodFillUtil(screen, x, y, prevC, newC);
	}

	// A recursive function to replace previous color 'prevC' at  '(x, y)' 
	// and all surrounding pixels of (x, y) with new color 'newC' and
	static void floodFillUtil(int screen[][], int x, int y, int prevC, int newC)
	{
		// Base cases
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length)
			return;
		if (screen[x][y] != prevC)
			return;

		// Replace the color at (x, y)
		screen[x][y] = newC;

		// Recur for north, east, south and west
		floodFillUtil(screen, x+1, y, prevC, newC);
		floodFillUtil(screen, x-1, y, prevC, newC);
		floodFillUtil(screen, x, y+1, prevC, newC);
		floodFillUtil(screen, x, y-1, prevC, newC);
	}

	public static void main(String[] args) {
		int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 1},
				{1, 2, 2, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 2, 2, 0},
				{1, 1, 1, 1, 1, 2, 1, 1},
				{1, 1, 1, 1, 1, 2, 2, 1},
		};
		int x = 4, y = 4, newC = 3;
		floodFill(screen, x, y, newC);

		System.out.println( "Updated screen after call to floodFill: \n");
		for (int i=0; i < screen.length; i++)
		{
			for (int j=0; j < screen[0].length; j++)
				System.out.print(screen[i][j] + " ");
			System.out.println();
		}


	}
}
