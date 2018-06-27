
public class UniquePathII {
    /*
    if its a one, then its zero. else same as the previous one.
    
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    if(i == m - 1 && j == n - 1) dp[i][j] = 1;
                    else dp[i][j] = (i + 1 >= m ? 0 : dp[i + 1][j]) + (j + 1 >= n ? 0 : dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
