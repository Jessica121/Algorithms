import java.util.Arrays;

public class solveSudoku {
	    /*
	    Still use bit manipulation and backtracking.
	    for each digit, set bit to the array. 1 << val | cell.
	    if a dot, check from 1 to 9, check bit not there by 1 << val & cell >= 1. if does, continue.
	    else set the three bits by 1 << val | cell. then backtrack. recursion pass in row and col
	    then remove bit by -1 << val - 1 & cell.
	    
	    block is i / 3 * 3 + j / 3
	    
	    */
	    public static void solveSudokuu(char[][] board) {
	        int[] row = new int[9], col = new int[9], block = new int[9];
	        check(board, 0, row, col, block);
	    }
	    
	    private static boolean check(char[][] board, int rc, int[] row, int[] col, int[] block) {
	        if(rc == 81) return true;
	        // System.out.println( rc / 10 + ", " + rc % 10);
	        print(board);
	        for(int i = rc / 9; i < board.length; i++) {
	            for(int j = rc % 9; j < board[0].length; j++) {
	                if(board[i][j] != '.') {
	                    setBit(row, col, block, i, j, board[i][j] - '0');
	                } else {
	                    for(int k = 1; k < 10; k++) {
	                        if(!isNotValid(row, col, block, i, j, k)) {
	                            System.out.println(i + ", " + j + ", " + k);
	                            setBit(row, col, block, i, j, k);
	                            board[i][j] = (char) (k + '0');                             System.out.println(i * 9 + j + 1);

	                            boolean next = check(board, i * 9 + j + 1, row, col, block);
	                            if(next) return true;
	                            resetBit(row, col, block, i, j, k);
	                            board[i][j] = '.';
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return false;
	    }
	    
	    private static void print(char[][] board) {
	        for(char[] c : board) System.out.println(Arrays.toString(c));
	    }
	    
	    private static boolean isNotValid(int[] row, int[] col, int[] block, int i, int j, int val) {
	        int mask = 1 << val;
	        return (row[i] & mask) >= 1 || (col[j] & mask) >= 1 || (block[i / 3 * 3 + j / 3] & mask) >= 1;
	    }
	    
	    private static void setBit(int[] row, int[] col, int[] b, int i, int j, int val) {
	        int mask = 1 << val;
	        row[i] |= mask;
	        col[j] |= mask;
	        b[i / 3 * 3 + j / 3] |= mask;
	    }
	    
	    private static void resetBit(int[] row, int[] col, int[] b, int i, int j, int val) {
	        int mask = (-1 << val) - 1;
	        row[i] &= mask;
	        col[j] &= mask;
	        b[i / 3 * 3 + j / 3] &= mask;
	    }
	    
	    public static void main(String[] args) {
	    	char[][] b = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
	    				{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
	    				{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
	    				{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
	    				{'.','.','.','.','8','.','.','7','9'}};
	    	solveSudokuu(b);
	    }
	    
	    
	    /*
	    The idea really is, do it each by each, return the next. if next not work, backtrack.
	    confused about backtracking when to use a loop and when not.
	    for each dot, try with 1 to 9 and check row, col, block has that number or not. 
	    if does not, go to the next cell, if next cell is true, return true, else back track.
	    if it does, not going in at all.
	    if not a dot, return next.
	    when rc == 81, return ture;
	    */
	    public void solveSudokuCorrect(char[][] board) {
	        solve(board, 0);
	    }
	    
	    private boolean solve(char[][] b, int rc) {
	        if(rc == 81) return true;
	        int i = rc / 9, j = rc % 9;
	        if(b[i][j] != '.') return solve(b, rc + 1);
	        else {
	            for(char c = '1'; c <= '9'; c++) {
	                if(isValid(b, i, j, c)) {
	                    b[i][j] = c;
	                    if(solve(b, rc + 1)) return true;
	                    b[i][j] = '.';
	                }
	            }
	            return false;
	        }
	    }
	    
	    private boolean isValid(char[][] b, int r, int c, char cha) {
	        for(int i = 0; i < 9; i++) {
	            if(b[r][i] == cha || b[i][c] == cha) return false;
	        }
	        for(int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
	            for(int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
	                if(b[i][j] == cha) return false;
	            } 
	        }
	        return true;
	    }
}
