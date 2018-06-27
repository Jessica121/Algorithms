
public class SetMatrixZero {
    /*
    check row and col have zeroes first. 
    then in the body of the matrix, if there is a zero, set its [0][col] and [row][0] into 0
    check, when [0][col] == 0 || [row][0] == 0 set itself zero, except for the first col. the row 0 can be set as zero when the row flag is zero.
    
    */
    public void setZeroes(int[][] matrix) {
        boolean row = checkRow(matrix), col = checkCol(matrix);
        markMatrix(matrix);
        for(int i = matrix.length - 1; i >= 1; i--) {
            for(int j = matrix[0].length - 1; j >= 1; j--) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        if(row) setRowZero(matrix);
        if(col) setColZero(matrix);
    }
    
    public boolean checkRow(int[][] matrix) {
        for(int j = 0; j < matrix[0].length; j++) if(matrix[0][j] == 0) return true;
        return false;
    }
    
    public boolean checkCol(int[][] matrix) {
        for(int j = 0; j < matrix.length; j++) if(matrix[j][0] == 0) return true;
        return false;
    }
    
    public void setColZero(int[][] matrix) {
        for(int j = 0; j < matrix.length; j++) matrix[j][0] = 0;
    }
    
    public void setRowZero(int[][] matrix) {
        for(int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
    }
    
    private void markMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
    }
    
    /*
    Matrix: constant space: modify directly on the matrix. (set flag, or DFS / BFS mark visited)
    or bit manipulation on the orgindal data (game of life)
    or swap on the matrix (rotate image)
    
    use the first row and col as the check row / col
    if itself has 0, use two flag to mark, but dont mark its first col in the row or first row in the col. will cause error to set row / col which should not be set to 0
    from i, j = 1, if self is 0, set[0][col] = 0 & [row][0] = 0
    iterate, when [0][col] == 0 || [row][0] == 0 set self to zero. 
    after set row 0 and col 0 into 0 if row / col flag indicates 0
    set O(N^2) 
    check O(N^2)
    
    */
    public void setZeroesGood(int[][] matrix) {
        boolean row = false, col = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                    if(i != 0 && j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        // the col when reach zero does not have effect on the row anymore.
        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if((i == 0 && row) || (j == 0 && col) || matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
