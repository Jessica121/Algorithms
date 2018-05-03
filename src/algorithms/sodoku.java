package algorithms;

import java.util.Arrays;

public class sodoku {

	public static void main(String[] args) {
		char[][] board = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		solveSudoku(board);
		 for(int i = 0; i < board.length; i++) {
             System.out.println(Arrays.toString(board[i]));
         }

	}

	public static void solveSudoku(char[][] board) {
        boolean[][] chk = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.') {
                    chk[i][board[i][j] - '0' - 1] = true;
                    chk[board[i][j] - '0' - 1][j] = true;
                }
            }
        }
        cal(board, chk); 
    }
    
    private static boolean cal(char[][] board, boolean[][] chk) {
//        if(rc == board.length * board.length) {
//            for(int z = 0; z < board.length; z++) {
//                                System.out.println(Arrays.toString(chk[z]));
//                            }
//                            System.out.println();
//            return true;
//        }
        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(!chk[i][k - '0' - 1] && !chk[k - '0' - 1][j]) {
                            board[i][j] = k;
                            chk[i][k - '0' - 1] = true;
                            chk[k - '0' - 1][j] = true; //System.out.println(i * j + 1);
                          for(int z = 0; z < board.length; z++) {
                              System.out.println(Arrays.toString(board[z]));
                          }
                          System.out.println();
                            if(cal(board, chk)) return true;
                            board[i][j] = '.';
                            chk[i][k - '0' - 1] = false;
                            chk[k - '0' - 1][j] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
