package leetcode.BFSDFS;

/*
 * https://leetcode.com/problems/word-search/#/description
 */
public class WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * For example, given board =
     * [
     *  ['A','B','C','E'],
     *  ['S','F','C','S'],
     *  ['A','D','E','E']
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     * 
     * @param board The given board of letters
     * @param word The word about whose existence we are asked
     * @return true if the word exists in the board,
     *         false otherwise
     */
    public boolean exist(char[][] board, String word) {
        // Store instance variables
        char[] w = word.toCharArray();
        
        /**
         * If we were performing multiple searches for a given board, we would
         * want to sort the board tiles somehow to make better guesses about
         * where to start.
         * 
         * Unfortunately, we only make one guess per board that we are given,
         * so sorting adds a factor of log(n) cost to an otherwise O(n) search.
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }
    
    /**
     * Recursively searches for the next character in the word in the adjacent
     * cells of the current cell.
     * 
     * Returns true when the last letter of the word has been found in a valid
     * adjacency.
     * 
     * @param i The row of the cell
     * @param j The column of the cell
     * @param d The "depth" of recursion
     * @return false if the current letter is not present at the current cell
     *         false if the current cell is not a validly-indexed location
     *         true if the depth of recursion equals the length of the word
     */
    private boolean exist(char[][] board, int i, int j, char[] word, int index) {
        
        // Our base cases
        if (index == word.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (board[i][j] != word[index]) return false;
        
        // Perform a bitwise OR assignment to mark the current cell as visited.
        // The bitwise OR of any character will not be the letter which is
        // currently being looked for.
        board[i][j] ^= 256;        //board[i][j] = '*'
        
        // Check all neighbors for existence of next letter.
        boolean ex = exist(board, i, j+1, word, index + 1) || 
        		     exist(board, i, j-1, word, index + 1) || 
        		     exist(board, i+1, j, word, index + 1) || 
        		     exist(board, i-1, j, word, index + 1);
        
        // Perform a bitwise OR assignment to revert the visited cells to the
        // letter they held previously.  OR(OR(X)) = X
        board[i][j] ^= 256;       //board[i][j] = word[index];
        
        return ex;
    }
}
