package leetcode.Design;

/*
 * https://leetcode.com/problems/battleships-in-a-board/#/description
 * A head of a battleship means the top most or left most cell with value 'X'.
 * Thus, we only need to count those heads.
 */
public class BattleShipBoard {
	public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' &&
                        (i == 0 || board[i - 1][j] == '.') &&
                        (j == 0 || board[i][j - 1] == '.')) {
                    result++;
                }

            }
        }
        return result;
    }
}
