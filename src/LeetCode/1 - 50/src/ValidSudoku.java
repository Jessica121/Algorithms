
public class ValidSudoku {
    /*
    Well this is really so silly that i could not believe what i think. the only part is know which 3*3 block each 0 - 9 index it belongs too.
    However, using bit manipulation is pretty darn smart. when checking the exist / non-exist problem, even with numbers, bit manipulation is pretty smart with basically no excptions.
    So i am gonna go with it.
    so, left shift the val for 1 and AND with the rol and row and the block it belongs to. if already 1, false.
    else set the bit by OR with it.
    
    checking block: row / 3 * 3 + col / 3
    
    */
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9], block = new int[9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int shift = board[i][j] - '0', mask = 1 << shift;
                    // you check the bit by shift the things want to check not shift 1 and AND with it to check it is 1! you can check by >= 1!
                    // if(((row[i] >> shift) & 1) == 1 || ((col[j] >> shift) & 1) == 1 || ((block[(i / 3) * 3 + j / 3] >> shift) & 1) == 1) return false;
                    if((row[i] & mask) >= 1 || (col[j] & mask) >= 1 || (block[(i / 3) * 3 + j / 3] & mask) >= 1) return false;
                    row[i] |= mask;
                    col[j] |= mask;
                    block[(i / 3) * 3 + j / 3] |= mask;
                }
            }
        }
        return true;
    }
    
    
}
