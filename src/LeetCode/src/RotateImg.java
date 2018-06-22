
public class RotateImg {
    /*
    Swap in diagonal: i, j with j, i
    then swap j from: 0 .. len / 2
    
    */
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length / 2; j++) {
                swap(matrix, i, j, i, matrix[0].length - j - 1);
            }
        }
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
