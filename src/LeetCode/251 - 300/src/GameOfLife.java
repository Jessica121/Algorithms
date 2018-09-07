
public class GameOfLife {
    /*
    does not have to be bit manpulation:
    for the next generation: + 10 if lives, else dont do anything.
    count the 8 neibors, how many are alive, and decide next generation based on center alives or not and the neibors.
    to restore the results, / 10 for every one.
    
    */
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(lives(board, i, j)) board[i][j] += 10;
            }
        }
        restore(board);
    }
    
    private boolean lives(int[][] board, int i, int j) {
        int[] dir = {0, -1, -1, 0, 1, 1, -1, 1, 0};
        int liveCnt = 0;
        for(int k = 0; k < dir.length - 1; k++) {
            if(outOfBound(board, i + dir[k], j + dir[k + 1])) continue;
            int nei = board[i + dir[k]][j + dir[k + 1]] % 10;
            liveCnt += nei == 0 ? 0 : 1;
        }
        // at this time, board[i][j] could only be 1 or 0.
        if(board[i][j] == 0) return liveCnt == 3;
        else return liveCnt == 2 || liveCnt == 3;
    }
    
    private boolean outOfBound(int[][] board, int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }
    
    private void restore(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] /= 10;
            }
        }
    }
}
