package leetcode.Design;

public class TicTacToe {

	//O(1)
	class TicTacToeBest {
		private int[] rows;
		private int[] cols;
		private int diagonal;
		private int antiDiagonal;

		/** Initialize your data structure here. */
		public TicTacToeBest(int n) {
			rows = new int[n];
			cols = new int[n];
		}

		/** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
		public int move(int row, int col, int player) {
			int toAdd = player == 1 ? 1 : -1;

			rows[row] += toAdd;
			cols[col] += toAdd;
			if (row == col)
			{
				diagonal += toAdd;
			}

			if (col == (cols.length - row - 1))
			{
				antiDiagonal += toAdd;
			}

			int size = rows.length;
			if (Math.abs(rows[row]) == size ||
					Math.abs(cols[col]) == size ||
					Math.abs(diagonal) == size  ||
					Math.abs(antiDiagonal) == size)
			{
				return player;
			}

			return 0;
		}
	}

	//O(n)
	class TicTacToeBetter {
		int[][] board;
		/** Initialize your data structure here. */
		public TicTacToeBetter(int n) {
			board = new int[n][n]; 
		}

		/** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
		public int move(int row, int col, int player) {
			int rowCount = 0, columnCount = 0, diagonal = 0,antiDiagonal = 0;
			board[row][col] = player;
			for(int i=0;i < board.length;i++){
				if(board[row][i] == player){
					rowCount++;
				}
			}
			for(int i =0;i < board.length;i++){
				if(board[i][col] == player){
					columnCount++;
				}
			}
			for(int i =0 ;i < board.length;i++){
				if(board[i][i] == player){
					diagonal++;
				}
			}

			int j = 0;
			for(int i = board.length - 1;i>=0;i--){
				if(board[j][i] == player ){
					antiDiagonal++;
				}
				j++;
			}

			int size = board.length;
			if(rowCount == size || columnCount == size || diagonal == size || antiDiagonal == size){
				return player;
			}else {
				return 0;
			}
		}
	}

	//O(n^2)
	class TicTacToeNaive {
		int[][] matrix;

		/** Initialize your data structure here. */
		public TicTacToeNaive(int n) {
			matrix = new int[n][n];
		}
		public int move(int row, int col, int player) {
			matrix[row][col]=player;

			//check row
			boolean win=true;
			for(int i=0; i<matrix.length; i++){
				if(matrix[row][i]!=player){
					win=false;
					break;
				}
			}
			if(win) return player;

			//check column
			win=true;
			for(int i=0; i<matrix.length; i++){
				if(matrix[i][col]!=player){
					win=false;
					break;
				}
			}
			if(win) return player;

			//check back diagonal
			win=true;
			for(int i=0; i<matrix.length; i++){
				if(matrix[i][i]!=player){
					win=false;
					break;
				}
			}
			if(win) return player;

			//check forward diagonal
			win=true;
			for(int i=0; i<matrix.length; i++){
				if(matrix[i][matrix.length-i-1]!=player){
					win=false;
					break;
				}
			}
			if(win) return player;
			return 0;
		}
	}
}
