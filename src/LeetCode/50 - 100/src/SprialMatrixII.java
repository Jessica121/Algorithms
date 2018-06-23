
public class SprialMatrixII {
    /*
    Same logic as the sparial I
    top down left right. put i = 0 to n^2 
    
    */
    public int[][] generateMatrix(int n) {
        int k = 1;
        int[][] res = new int[n][n];
        int top = 0, down = n - 1, left = 0, right = n - 1;
        while(k <= n * n) {
            for(int i = left; i <= right; i++) res[top][i] = k++;
            top++;
            for(int i = top; i <= down; i++) res[i][right] = k++;
            right--;
            for(int i = right; i >= left; i--) res[down][i] = k++;
            down--;
            for(int i = down; i >= top; i--) res[i][left] = k++;
            left++;
        }
        return res;
    }
}
