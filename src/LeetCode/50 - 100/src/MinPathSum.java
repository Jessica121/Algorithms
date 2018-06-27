
public class MinPathSum {
    /*
    if known the min of [i][j + 1] and min of [i + 1][j] choose the min one and add itself
    
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) dp[i][j] = grid[i][j];
                else dp[i][j] = Math.min((i + 1 >= m ? Integer.MAX_VALUE : dp[i + 1][j]), (j + 1 >= n ? Integer.MAX_VALUE : dp[i][j + 1])) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
