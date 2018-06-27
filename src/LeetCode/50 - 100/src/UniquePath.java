
public class UniquePath {
    /*
    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
    
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) dp[i][j] = 1;
                // parenthese for ? : grammar
                else dp[i][j] = ((i + 1) >= m ? 0 : dp[i + 1][j]) + ((j + 1) >= n ? 0 : dp[i][j + 1]);
            }
        }
        // for(int i = 0; i < m; i++) System.out.println(Arrays.toString(dp[i]));
        return dp[0][0];
    }
}
