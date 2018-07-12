
public class Search2DMatrixII {
    /*
    start with right upper corner: i = 0, j = matrix.length - 1
    if value > target, goes left, j--.
    if value < target, goes down, i++
    if equal, return true.
    out of bounds return false.
    corner case: matrix is empty!!!!!
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
